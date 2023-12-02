/*
 * Copyright 2016 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hippo.ehviewer.client

import android.util.Log
import arrow.core.Either
import arrow.core.left
import arrow.core.right
import arrow.fx.coroutines.parMap
import arrow.fx.coroutines.parZip
import com.hippo.ehviewer.R
import com.hippo.ehviewer.Settings
import com.hippo.ehviewer.client.data.BaseGalleryInfo
import com.hippo.ehviewer.client.data.FavListUrlBuilder
import com.hippo.ehviewer.client.data.GalleryInfo
import com.hippo.ehviewer.client.exception.EhException
import com.hippo.ehviewer.client.exception.InsufficientFundsException
import com.hippo.ehviewer.client.exception.NotLoggedInException
import com.hippo.ehviewer.client.exception.ParseException
import com.hippo.ehviewer.client.parser.ArchiveParser
import com.hippo.ehviewer.client.parser.EventPaneParser
import com.hippo.ehviewer.client.parser.FavoritesParser
import com.hippo.ehviewer.client.parser.ForumsParser
import com.hippo.ehviewer.client.parser.GalleryApiParser
import com.hippo.ehviewer.client.parser.GalleryDetailParser
import com.hippo.ehviewer.client.parser.GalleryListParser
import com.hippo.ehviewer.client.parser.GalleryNotAvailableParser
import com.hippo.ehviewer.client.parser.GalleryPageParser
import com.hippo.ehviewer.client.parser.GalleryTokenApiParser
import com.hippo.ehviewer.client.parser.HomeParser
import com.hippo.ehviewer.client.parser.ProfileParser
import com.hippo.ehviewer.client.parser.RateGalleryResult
import com.hippo.ehviewer.client.parser.SignInParser
import com.hippo.ehviewer.client.parser.TorrentParser
import com.hippo.ehviewer.client.parser.TorrentResult
import com.hippo.ehviewer.client.parser.VoteCommentResult
import com.hippo.ehviewer.client.parser.VoteTagParser
import com.hippo.ehviewer.cronet.awaitBodyFully
import com.hippo.ehviewer.cronet.cronetRequest
import com.hippo.ehviewer.cronet.execute
import com.hippo.ehviewer.cronet.withRequestBody
import com.hippo.ehviewer.dailycheck.showEventNotification
import com.hippo.ehviewer.dailycheck.today
import com.hippo.ehviewer.util.AppConfig
import com.hippo.ehviewer.util.StatusCodeException
import com.hippo.ehviewer.util.isCronetSupported
import eu.kanade.tachiyomi.util.system.logcat
import io.ktor.client.statement.HttpStatement
import io.ktor.client.statement.bodyAsChannel
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.request
import io.ktor.utils.io.pool.DirectByteBufferPool
import io.ktor.utils.io.pool.useInstance
import java.io.File
import java.nio.ByteBuffer
import kotlin.math.ceil
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.add
import kotlinx.serialization.json.addJsonArray
import kotlinx.serialization.json.put
import moe.tarsin.coroutines.removeAllSuspend
import moe.tarsin.coroutines.runSuspendCatching
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.jsoup.Jsoup
import splitties.init.appCtx

const val TAG = "EhEngine"
private const val MAX_REQUEST_SIZE = 25
private const val U_CONFIG_TEXT = "Selected Profile"
private val MEDIA_TYPE_JPEG: MediaType = "image/jpeg".toMediaType()

fun rethrowExactly(code: Int, body: Either<String, ByteBuffer>, e: Throwable): Nothing {
    // Don't translate coroutine cancellation
    if (e is CancellationException) throw e

    // Check sad panda(without panda)
    val empty = body.fold(
        { it.isEmpty() },
        { !it.hasRemaining() },
    )
    if (empty) {
        if (EhUtils.isExHentai) {
            throw EhException("Sad Panda\n(without panda)")
        } else {
            throw EhException("IP banned")
        }
    }

    // Check Gallery Not Available
    body.onLeft {
        if ("Gallery Not Available - " in it) {
            val error = GalleryNotAvailableParser.parse(it)
            if (!error.isNullOrBlank()) {
                throw EhException(error)
            }
        }
    }

    // Check bad response code
    if (code >= 400) {
        throw StatusCodeException(code)
    }

    if (e is ParseException || e is SerializationException) {
        body.onLeft {
            if ("<" !in it) {
                throw EhException(it)
            } else {
                if (Settings.saveParseErrorBody) AppConfig.saveParseErrorBody(e, it)
                throw EhException(appCtx.getString(R.string.error_parse_error), e)
            }
        }
        body.onRight {
        }
        // Save content for ByteBuffer as well
    }

    // We can't translate it, rethrow it anyway
    throw e
}

val httpContentPool = DirectByteBufferPool(8, 0x80000)

suspend fun <T> fetchCompat(
    url: String,
    referer: String? = null,
    origin: String? = null,
    reqBody: RequestBody? = null,
    parser: suspend (ByteBuffer) -> T,
): T {
    Log.d(TAG, url)
    fun commonChecks(body: ByteBuffer) {
        // Check sad panda(without panda)
        if (!body.hasRemaining()) {
            if (EhUtils.isExHentai) {
                throw EhException("Sad Panda\n(without panda)")
            } else {
                throw EhException("IP banned")
            }
        }
    }
    return if (isCronetSupported) {
        cronetRequest(url, referer, origin) {
            reqBody?.let { withRequestBody(it) }
        }.execute {
            @Suppress("NewApi")
            val code = it.httpStatusCode
            if (code >= 400) {
                throw StatusCodeException(code)
            }
            httpContentPool.useInstance { buffer ->
                awaitBodyFully(buffer)
                buffer.flip()
                commonChecks(buffer)
                parser(buffer)
            }
        }
    } else {
        ehRequest(url, referer, origin) {
            reqBody?.let { post(it) }
        }.execute {
            httpContentPool.useInstance { buffer ->
                while (true) {
                    if (body.source().read(buffer) == -1) break
                }
                buffer.flip()
                commonChecks(buffer)
                parser(buffer)
            }
        }
    }
}

suspend inline fun <T> HttpStatement.parseString(crossinline block: suspend String.() -> T) = execute { response ->
    logcat(tag = TAG) { response.request.url.toString() }
    val body = response.bodyAsText()
    runSuspendCatching {
        block(body)
    }.onFailure {
        rethrowExactly(response.status.value, body.left(), it)
    }.getOrThrow()
}

suspend inline fun <T> HttpStatement.parseByteBuffer(crossinline block: suspend ByteBuffer.() -> T) = execute { response ->
    logcat(tag = TAG) { response.request.url.toString() }
    httpContentPool.useInstance { buffer ->
        with(response.bodyAsChannel()) { while (!isClosedForRead) readAvailable(buffer) }
        buffer.flip()
        runSuspendCatching {
            block(buffer)
        }.onFailure {
            rethrowExactly(response.status.value, buffer.right(), it)
        }.getOrThrow()
    }
}

object EhEngine {
    suspend fun getOriginalImageUrl(url: String, referer: String?): String {
        return noRedirectStatement(url, referer).execute {
            it.headers["Location"]?.apply {
                if (contains("bounce_login")) throw NotLoggedInException()
            } ?: throw InsufficientFundsException()
        }
    }

    suspend fun getTorrentList(url: String, gid: Long, token: String?): TorrentResult {
        val referer = EhUrl.getGalleryDetailUrl(gid, token)
        return statement(url, referer).parseByteBuffer(TorrentParser::parse)
    }

    suspend fun getArchiveList(url: String, gid: Long, token: String?) = statement(url, EhUrl.getGalleryDetailUrl(gid, token))
        .parseString(ArchiveParser::parse)
        .apply { funds = funds ?: statement(EhUrl.URL_FUNDS).parseString(HomeParser::parseFunds) }

    suspend fun getImageLimits() = parZip(
        { statement(EhUrl.URL_HOME).parseByteBuffer(HomeParser::parse) },
        { statement(EhUrl.URL_FUNDS).parseString(HomeParser::parseFunds) },
        { limits, funds -> HomeParser.Result(limits, funds) },
    )

    suspend fun getNews(parse: Boolean) = statement(EhUrl.URL_NEWS, EhUrl.REFERER_E)
        .parseString { if (parse) EventPaneParser.parse(this) else null }

    suspend fun getProfile(): ProfileParser.Result {
        val url = statement(EhUrl.URL_FORUMS).parseString(ForumsParser::parse)
        return statement(url, EhUrl.URL_FORUMS).parseString(ProfileParser::parse)
    }

    suspend fun getUConfig(url: String = EhUrl.uConfigUrl) {
        runSuspendCatching {
            statement(url).parseString { check(U_CONFIG_TEXT in this) { "Unable to load config from $url!" } }
        }.onFailure { throwable ->
            // It may get redirected when accessing ex for the first time
            if (url == EhUrl.URL_UCONFIG_EX) {
                throwable.printStackTrace()
                statement(url).parseString { check(U_CONFIG_TEXT in this) { "Unable to load config from $url!" } }
            } else {
                throw throwable
            }
        }
    }

    suspend fun getGalleryPage(
        url: String,
        gid: Long,
        token: String?,
    ): GalleryPageParser.Result {
        val referer = EhUrl.getGalleryDetailUrl(gid, token)
        return statement(url, referer).parseString(GalleryPageParser::parse)
    }

    suspend fun getGalleryList(url: String) = statement(url, EhUrl.referer).parseByteBuffer(GalleryListParser::parse)
        .apply { fillGalleryList(galleryInfoList, url, true) }
        .takeUnless { it.galleryInfoList.isEmpty() } ?: GalleryListParser.emptyResult

    suspend fun getGalleryDetail(url: String) = statement(url, EhUrl.referer).parseString {
        val eventPane = EventPaneParser.parse(this)
        if (eventPane != null) {
            Settings.lastDawnDay = today
            showEventNotification(eventPane)
        }
        GalleryDetailParser.parse(this)
    }

    suspend fun getPreviewList(url: String) = statement(url, EhUrl.referer).parseString {
        GalleryDetailParser.parsePreviewList(this) to GalleryDetailParser.parsePreviewPages(this)
    }

    suspend fun getFavorites(url: String) = statement(url, EhUrl.referer).parseByteBuffer(FavoritesParser::parse)
        .apply { fillGalleryList(galleryInfoList, url) }

    suspend fun signIn(username: String, password: String): String {
        val referer = "https://forums.e-hentai.org/index.php?act=Login&CODE=00"
        val url = EhUrl.API_SIGN_IN
        val origin = "https://forums.e-hentai.org"
        return statement(url, referer, origin) {
            formBody {
                append("referer", referer)
                append("b", "")
                append("bt", "")
                append("UserName", username)
                append("PassWord", password)
                append("CookieDate", "1")
            }
        }.parseString(SignInParser::parse)
    }

    suspend fun commentGallery(url: String, comment: String, id: Long = -1) = statement(url, url, EhUrl.origin) {
        formBody {
            if (id == -1L) {
                append("commenttext_new", comment)
            } else {
                append("commenttext_edit", comment)
                append("edit_comment", id.toString())
            }
        }
    }.parseString {
        val document = Jsoup.parse(this)
        val elements = document.select("#chd + p")
        if (elements.size > 0) {
            throw EhException(elements[0].text())
        }
        GalleryDetailParser.parseComments(document)
    }

    suspend fun modifyFavorites(gid: Long, token: String?, dstCat: Int = -1, note: String = "") {
        val catStr: String = when (dstCat) {
            -1 -> "favdel"
            in 0..9 -> dstCat.toString()
            else -> throw EhException("Invalid dstCat: $dstCat")
        }
        val url = EhUrl.getAddFavorites(gid, token)
        statement(url, url, EhUrl.origin) {
            formBody {
                append("favcat", catStr)
                append("favnote", note)
                // apply=Add+to+Favorites is not necessary, just use apply=Apply+Changes all the time
                append("apply", "Apply Changes")
                append("update", "1")
            }
        }.execute { }
    }

    suspend fun downloadArchive(
        gid: Long,
        token: String?,
        or: String?,
        res: String?,
        isHAtH: Boolean,
    ): String? {
        if (or.isNullOrEmpty()) {
            throw EhException("Invalid form param or: $or")
        }
        if (res.isNullOrEmpty()) {
            throw EhException("Invalid res: $res")
        }
        val url = EhUrl.getDownloadArchive(gid, token, or)
        val referer = EhUrl.getGalleryDetailUrl(gid, token)
        val request = statement(url, referer, EhUrl.origin) {
            formBody {
                if (isHAtH) {
                    append("hathdl_xres", res)
                } else {
                    append("dltype", res)
                    if (res == "org") {
                        append("dlcheck", "Download Original Archive")
                    } else {
                        append("dlcheck", "Download Resample Archive")
                    }
                }
            }
        }
        var result = request.parseString(ArchiveParser::parseArchiveUrl)
        if (!isHAtH) {
            if (result == null) {
                // Wait for the server to prepare archives
                delay(1000)
                result = request.parseString(ArchiveParser::parseArchiveUrl)
                if (result == null) {
                    throw EhException("Archive unavailable")
                }
            }
            return result
        }
        return null
    }

    suspend fun resetImageLimits() = statement(EhUrl.URL_HOME) {
        formBody {
            append("reset_imagelimit", "Reset Limit")
        }
    }.parseString(HomeParser::parseResetLimits)

    suspend fun modifyFavorites(gidArray: LongArray, srcCat: Int, dstCat: Int): FavoritesParser.Result {
        val url = ehUrl {
            addPathSegments(EhUrl.FAV_PATH)
            if (FavListUrlBuilder.isValidFavCat(srcCat)) {
                addQueryParameter("favcat", srcCat.toString())
            }
        }.toString()
        val catStr: String = when (dstCat) {
            -1 -> "delete"
            in 0..9 -> "fav$dstCat"
            else -> throw EhException("Invalid dstCat: $dstCat")
        }
        return statement(url, url, EhUrl.origin) {
            formBody {
                append("ddact", catStr)
                gidArray.forEach { append("modifygids[]", it.toString()) }
            }
        }.parseByteBuffer(FavoritesParser::parse).apply { fillGalleryList(galleryInfoList, url) }
    }

    suspend fun getGalleryPageApi(
        gid: Long,
        index: Int,
        pToken: String,
        showKey: String?,
        previousPToken: String?,
    ): GalleryPageParser.Result {
        val referer = if (index > 0 && previousPToken != null) EhUrl.getPageUrl(gid, index - 1, previousPToken) else null
        return statement(EhUrl.apiUrl, referer, EhUrl.origin) {
            jsonBody {
                put("method", "showpage")
                put("gid", gid)
                put("page", index + 1)
                put("imgkey", pToken)
                put("showkey", showKey)
            }
        }.parseString { GalleryPageParser.parse(filterNot { it == '\\' }) }
    }

    suspend fun rateGallery(
        apiUid: Long,
        apiKey: String?,
        gid: Long,
        token: String?,
        rating: Float,
    ): RateGalleryResult = statement(EhUrl.apiUrl, EhUrl.getGalleryDetailUrl(gid, token), EhUrl.origin) {
        jsonBody {
            put("method", "rategallery")
            put("apiuid", apiUid)
            put("apikey", apiKey)
            put("gid", gid)
            put("token", token)
            put("rating", ceil((rating * 2).toDouble()).toInt())
        }
    }.parseString(String::parseAs)

    suspend fun fillGalleryListByApi(galleryInfoList: List<GalleryInfo>, referer: String) =
        galleryInfoList.chunked(MAX_REQUEST_SIZE).parMap(concurrency = Settings.multiThreadDownload) {
            statement(EhUrl.apiUrl, referer, EhUrl.origin) {
                jsonBody {
                    put("method", "gdata")
                    array("gidlist") {
                        it.forEach {
                            addJsonArray {
                                add(it.gid)
                                add(it.token)
                            }
                        }
                    }
                    put("namespace", 1)
                }
            }.parseString { GalleryApiParser.parse(this, it) }
        }

    suspend fun voteComment(
        apiUid: Long,
        apiKey: String?,
        gid: Long,
        token: String?,
        commentId: Long,
        commentVote: Int,
    ): VoteCommentResult = statement(EhUrl.apiUrl, EhUrl.referer, EhUrl.origin) {
        jsonBody {
            put("method", "votecomment")
            put("apiuid", apiUid)
            put("apikey", apiKey)
            put("gid", gid)
            put("token", token)
            put("comment_id", commentId)
            put("comment_vote", commentVote)
        }
    }.parseString(String::parseAs)

    suspend fun voteTag(
        apiUid: Long,
        apiKey: String?,
        gid: Long,
        token: String?,
        tags: String?,
        vote: Int,
    ) = statement(EhUrl.apiUrl, EhUrl.referer, EhUrl.origin) {
        jsonBody {
            put("method", "taggallery")
            put("apiuid", apiUid)
            put("apikey", apiKey)
            put("gid", gid)
            put("token", token)
            put("tags", tags)
            put("vote", vote)
        }
    }.parseString(VoteTagParser::parse)

    suspend fun getGalleryToken(gid: Long, gtoken: String?, page: Int) = statement(EhUrl.apiUrl, EhUrl.referer, EhUrl.origin) {
        jsonBody {
            put("method", "gtoken")
            array("pagelist") {
                addJsonArray {
                    add(gid)
                    add(gtoken)
                    add(page + 1)
                }
            }
        }
    }.parseString(GalleryTokenApiParser::parse)

    /**
     * @param image Must be jpeg
     */
    suspend fun imageSearch(image: File, uss: Boolean, osc: Boolean) = fetchCompat(
        EhUrl.imageSearchUrl,
        EhUrl.referer,
        EhUrl.origin,
        multipartBody {
            setType(MultipartBody.FORM)
            addFormDataPart("sfile", "a.jpg", image.asRequestBody(MEDIA_TYPE_JPEG))
            if (uss) addFormDataPart("fs_similar", "on")
            if (osc) addFormDataPart("fs_covers", "on")
            addFormDataPart("f_sfile", "File Search")
        },
        parser = GalleryListParser::parse,
    ).apply { fillGalleryList(galleryInfoList, EhUrl.imageSearchUrl) }

    private suspend fun fillGalleryList(list: MutableList<BaseGalleryInfo>, url: String, filter: Boolean = false) {
        if (filter) list.removeAllSuspend { EhFilter.filterTitle(it) || EhFilter.filterUploader(it) }

        var hasTags = false
        var hasPages = false
        var hasRated = false
        for (gi in list) {
            if (!gi.simpleTags.isNullOrEmpty()) {
                hasTags = true
            }
            if (gi.pages != 0) {
                hasPages = true
            }
            if (gi.rated) {
                hasRated = true
            }
        }
        val needApi = filter && EhFilter.needTags() && !hasTags || Settings.showGalleryPages && !hasPages || hasRated
        if (needApi) fillGalleryListByApi(list, url)

        if (filter) {
            list.removeAllSuspend {
                EhFilter.filterUploader(it) || EhFilter.filterTag(it) || EhFilter.filterTagNamespace(it)
            }
        }
    }

    suspend fun addFavorites(galleryList: List<Pair<Long, String>>, dstCat: Int) {
        galleryList.parMap(concurrency = Settings.multiThreadDownload) { (gid, token) ->
            modifyFavorites(gid, token, dstCat)
        }
    }
}
