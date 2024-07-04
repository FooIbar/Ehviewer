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
package com.hippo.ehviewer.spider

import android.webkit.MimeTypeMap
import arrow.fx.coroutines.autoCloseable
import arrow.fx.coroutines.closeable
import arrow.fx.coroutines.parMap
import arrow.fx.coroutines.resourceScope
import com.hippo.ehviewer.EhApplication.Companion.imageCache as sCache
import com.hippo.ehviewer.EhDB
import com.hippo.ehviewer.Settings
import com.hippo.ehviewer.client.EhEngine
import com.hippo.ehviewer.client.EhUtils.getSuitableTitle
import com.hippo.ehviewer.client.data.GalleryDetail
import com.hippo.ehviewer.client.data.GalleryInfo
import com.hippo.ehviewer.client.ehRequest
import com.hippo.ehviewer.client.executeSafely
import com.hippo.ehviewer.client.getImageKey
import com.hippo.ehviewer.coil.read
import com.hippo.ehviewer.coil.suspendEdit
import com.hippo.ehviewer.dao.DownloadArtist
import com.hippo.ehviewer.download.DownloadManager
import com.hippo.ehviewer.download.downloadLocation
import com.hippo.ehviewer.download.tempDownloadDir
import com.hippo.ehviewer.image.UniFileSource
import com.hippo.ehviewer.jni.archiveFdBatch
import com.hippo.ehviewer.util.FileUtils
import com.hippo.ehviewer.util.sendTo
import com.hippo.unifile.UniFile
import com.hippo.unifile.asUniFile
import com.hippo.unifile.openOutputStream
import com.hippo.unifile.sha1
import eu.kanade.tachiyomi.util.system.logcat
import io.ktor.client.plugins.onDownload
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.client.statement.request
import io.ktor.http.isSuccess
import io.ktor.utils.io.jvm.nio.copyTo
import kotlin.io.path.readText
import kotlinx.coroutines.CancellationException

class SpiderDen(val info: GalleryInfo) {
    private val gid = info.gid
    var downloadDir: UniFile? = null
        private set

    private var tempDownloadDir: UniFile? = null
    private val saveAsCbz = Settings.saveAsCbz
    private val archiveName = "$gid.cbz"

    // Search in both directories to maintain compatibility
    private val fileCache by lazy {
        (tempDownloadDir?.listFiles().orEmpty() + downloadDir?.listFiles().orEmpty()).associateBy {
            it.name!!
        } as HashMap
    }

    private fun findCached(name: String) = synchronized(fileCache) { fileCache[name] }

    private fun putCached(name: String, file: UniFile) = synchronized(fileCache) { fileCache[name] = file }

    private fun UniFile.deleteAndEvictCache() = name.let { name ->
        delete().also { succeed ->
            if (succeed) {
                synchronized(fileCache) {
                    fileCache.remove(name)
                }
            }
        }
    }

    private val imageDir
        get() = tempDownloadDir.takeIf { saveAsCbz } ?: downloadDir

    constructor(info: GalleryInfo, dirname: String) : this(info) {
        downloadDir = downloadLocation.findFile(dirname)
    }

    @Volatile
    @SpiderQueen.Mode
    var mode = SpiderQueen.MODE_READ
        private set

    suspend fun setMode(value: Int) {
        mode = value
        if (mode == SpiderQueen.MODE_DOWNLOAD) {
            if (downloadDir == null) {
                val dirname = EhDB.getDownloadDirname(gid)!!
                downloadDir = downloadLocation.createDirectory(dirname)!!
            }
            if (saveAsCbz && tempDownloadDir == null) {
                tempDownloadDir = info.tempDownloadDir!!
            }
        }
    }

    private fun containInCache(index: Int): Boolean {
        val key = getImageKey(gid, index)
        return sCache.read(key) { true } ?: false
    }

    private fun findImageFile(index: Int) = synchronized(fileCache) {
        val head = perFilename(index)
        fileCache.entries.firstOrNull { (name, _) -> name.startsWith(head) }?.value
    }

    private fun containInDownloadDir(index: Int): Boolean = findImageFile(index) != null

    private fun copyFromCacheToDownloadDir(index: Int): Boolean {
        val dir = imageDir ?: return false
        val key = getImageKey(gid, index)
        return runCatching {
            sCache.read(key) {
                val extension = metadata.toFile().readText()
                val filename = perFilename(index, extension)
                val file = dir.createFile(filename) ?: return false
                putCached(filename, file)
                data.asUniFile() sendTo file
                true
            } ?: false
        }.onFailure {
            logcat(it)
        }.getOrDefault(false)
    }

    operator fun contains(index: Int): Boolean = when (mode) {
        SpiderQueen.MODE_READ -> {
            containInCache(index) || containInDownloadDir(index)
        }

        SpiderQueen.MODE_DOWNLOAD -> {
            containInDownloadDir(index) || copyFromCacheToDownloadDir(index)
        }

        else -> {
            false
        }
    }

    private fun removeFromCache(index: Int): Boolean {
        val key = getImageKey(gid, index)
        return sCache.remove(key)
    }

    private fun removeFromDownloadDir(index: Int) = findImageFile(index)?.deleteAndEvictCache() ?: false

    fun remove(index: Int): Boolean = removeFromCache(index) or removeFromDownloadDir(index)

    private fun findDownloadFileForIndex(index: Int, extension: String): UniFile? = perFilename(index, extension).let { name ->
        imageDir?.createFile(name)?.also { file ->
            putCached(name, file)
        }
    }

    suspend fun makeHttpCallAndSaveImage(
        index: Int,
        url: String,
        referer: String?,
        notifyProgress: (Long, Long, Int) -> Unit,
    ) = ehRequest(url, referer) {
        var prev = 0L
        onDownload { done, total ->
            notifyProgress(total!!, done, (done - prev).toInt())
            prev = done
        }
    }.executeSafely {
        if (it.status.isSuccess()) {
            saveFromHttpResponse(index, it)
        } else {
            false
        }
    }

    private suspend inline fun saveResponseMeta(
        index: Int,
        ext: String,
        crossinline fops: suspend (UniFile) -> Unit,
    ): Boolean {
        findDownloadFileForIndex(index, ext)?.run {
            fops(this)
            return true
        }

        // Read Mode, allow save to cache
        if (mode == SpiderQueen.MODE_READ) {
            val key = getImageKey(gid, index)
            return sCache.suspendEdit(key) {
                metadata.toFile().writeText(ext)
                fops(data.asUniFile())
            }
        }
        return false
    }

    private suspend fun saveFromHttpResponse(index: Int, response: HttpResponse): Boolean {
        val url = response.request.url.toString()
        val extension = MimeTypeMap.getFileExtensionFromUrl(url).ifEmpty { "jpg" }
        return saveResponseMeta(index, extension) { outFile ->
            outFile.openOutputStream().use {
                response.bodyAsChannel().copyTo(it.channel)
            }
            val expected = FileHashRegex.findAll(url).last().groupValues[1]
            val actual = outFile.sha1()
            check(expected == actual) { "File hash mismatch: expected $expected, but got $actual\nURL: $url" }
        }
    }

    fun saveToUniFile(index: Int, file: UniFile): Boolean {
        val key = getImageKey(gid, index)

        // Read from diskCache first
        sCache.read(key) {
            runCatching {
                data.asUniFile() sendTo file
                return true
            }.onFailure {
                logcat(it)
                return false
            }
        }

        // Read from download dir
        runCatching {
            requireNotNull(findImageFile(index)) sendTo file
        }.onFailure {
            logcat(it)
            return false
        }.onSuccess {
            return true
        }
        return false
    }

    fun getExtension(index: Int): String? {
        val key = getImageKey(gid, index)
        return sCache.read(key) { metadata.toNioPath().readText() }
            ?: findImageFile(index)?.name.let { FileUtils.getExtensionFromFilename(it) }
    }

    fun getImageSource(index: Int): UniFileSource? {
        if (mode == SpiderQueen.MODE_READ) {
            val key = getImageKey(gid, index)
            val snapshot = sCache.openSnapshot(key)
            if (snapshot != null) {
                return object : UniFileSource, AutoCloseable by snapshot {
                    override val source = snapshot.data.asUniFile()
                    override val type by lazy {
                        snapshot.metadata.toNioPath().readText()
                    }
                }
            }
        }
        val source = findImageFile(index) ?: return null
        return object : UniFileSource {
            override val source = source
            override val type by lazy {
                FileUtils.getExtensionFromFilename(source.name)!!
            }

            override fun close() {}
        }
    }

    suspend fun archive() {
        if (saveAsCbz && !hasArchive()) {
            downloadDir?.createFile(archiveName)?.let { file ->
                runCatching {
                    archiveTo(file)
                    putCached(archiveName, file)
                }.onFailure {
                    file.delete()
                    if (it is CancellationException) throw it
                    logcat(it)
                }
            }
        }
    }

    private fun hasArchive() = findCached(archiveName) != null

    suspend fun postArchive(): Boolean {
        val archived = saveAsCbz && hasArchive()
        if (archived) {
            val files = synchronized(fileCache) { fileCache.values }
            files.parMap(concurrency = 10) {
                if (it.name?.matches(FileNameRegex) == true) {
                    it.deleteAndEvictCache()
                }
            }
            findCached(SpiderQueen.SPIDER_INFO_FILENAME)?.deleteAndEvictCache()
            tempDownloadDir?.delete()
        }
        return archived
    }

    suspend fun exportAsCbz(file: UniFile) = findCached(archiveName)?.sendTo(file) ?: archiveTo(file)

    private suspend fun archiveTo(file: UniFile) = resourceScope {
        val comicInfo = closeable {
            val f = findCached(COMIC_INFO_FILE) ?: writeComicInfo()!!
            if (info.pages == 0) {
                info.pages = readComicInfo(f)!!.pageCount
            }
            f.openFileDescriptor("r")
        }
        val pages = info.pages
        val (fdBatch, names) = (0 until pages).parMap { idx ->
            val f = autoCloseable { getImageSource(idx) ?: throw CancellationException("Image #$idx not found") }
            closeable { f.source.openFileDescriptor("r") }.fd to perFilename(idx, f.type)
        }.run { plus(comicInfo.fd to COMIC_INFO_FILE) }.unzip()
        val arcFd = closeable { file.openFileDescriptor("rw") }
        archiveFdBatch(fdBatch.toIntArray(), names.toTypedArray(), arcFd.fd, pages + 1)
    }

    suspend fun initDownloadDirIfExist() {
        downloadDir = EhDB.getDownloadDirname(gid)?.let { downloadLocation.findFile(it) }
        tempDownloadDir = info.tempDownloadDir?.takeIf { it.isDirectory }
    }

    suspend fun initDownloadDir() {
        val dirname = info.downloadDirname()
        downloadDir = downloadLocation.createDirectory(dirname)!!
    }

    suspend fun writeComicInfo(fetchMetadata: Boolean = true): UniFile? = downloadDir?.run {
        createFile(COMIC_INFO_FILE)?.also {
            putCached(COMIC_INFO_FILE, it)
            runCatching {
                if (info !is GalleryDetail && fetchMetadata) {
                    EhEngine.fillGalleryListByApi(listOf(info))
                }
                info.getComicInfo().apply {
                    write(it)
                    DownloadManager.getDownloadInfo(gid)?.let { downloadInfo ->
                        downloadInfo.artistInfoList = DownloadArtist.from(gid, penciller.orEmpty())
                        EhDB.putDownloadArtist(gid, downloadInfo.artistInfoList)
                    }
                }
            }.onFailure {
                logcat(it)
            }
        }
    }
}

private val FileNameRegex = Regex("^\\d{8}\\.\\w{3,4}")
private val FileHashRegex = Regex("/([0-9a-f]{40})(?:-\\d+){3}-\\w+")

fun perFilename(index: Int, extension: String = ""): String = "%08d.%s".format(index + 1, extension)

suspend fun GalleryInfo.downloadDirname(): String {
    var dirname = EhDB.getDownloadDirname(gid)
    if (dirname == null) {
        val title = getSuitableTitle(this)
        dirname = FileUtils.sanitizeFilename("$gid-$title")
        EhDB.putDownloadDirname(gid, dirname)
    }
    return dirname
}
