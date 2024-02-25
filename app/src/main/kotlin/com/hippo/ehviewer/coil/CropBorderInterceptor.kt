package com.hippo.ehviewer.coil

import android.graphics.Bitmap
import android.graphics.Rect
import coil3.BitmapImage
import coil3.Extras
import coil3.Image
import coil3.asCoilImage
import coil3.getExtra
import coil3.intercept.Interceptor
import coil3.intercept.Interceptor.Chain
import coil3.request.ImageRequest
import coil3.request.ImageResult
import coil3.request.SuccessResult
import coil3.request.allowHardware
import com.hippo.ehviewer.image.detectBorder
import com.hippo.ehviewer.util.isAtLeastO

private const val CROP_THRESHOLD = 0.75f

private val maybeCropBorderKey = Extras.Key(default = false)

fun ImageRequest.Builder.maybeCropBorder(enable: Boolean) = apply {
    extras[maybeCropBorderKey] = enable
}

val ImageRequest.maybeCropBorder: Boolean
    get() = getExtra(maybeCropBorderKey)

interface BitmapImageWithRect : Image {
    val rect: Rect
    val image: Image
}

object CropBorderInterceptor : Interceptor {
    override suspend fun intercept(chain: Chain): ImageResult {
        val req = chain.request
        if (req.maybeCropBorder) {
            val hw = req.allowHardware && isAtLeastO
            val result = if (hw) {
                val nonHw = req.newBuilder().allowHardware(false).build()
                chain.withRequest(nonHw).proceed()
            } else {
                chain.proceed()
            }
            if (result is SuccessResult) {
                val image = result.image
                if (image is BitmapImage) {
                    val bitmap = image.bitmap
                    val array = detectBorder(bitmap)
                    val r = Rect(array[0], array[1], array[2], array[3])
                    val minWidth = image.width * CROP_THRESHOLD
                    val minHeight = image.height * CROP_THRESHOLD
                    val maybeHwBitmap = if (hw) {
                        bitmap.copy(Bitmap.Config.HARDWARE, false).apply {
                            bitmap.recycle()
                        }
                    } else {
                        bitmap
                    }
                    val shouldOverride = r.width() > minWidth && r.height() > minHeight
                    val maybeHwImage = maybeHwBitmap.asCoilImage()
                    val new = if (shouldOverride) {
                        object : BitmapImageWithRect, Image by maybeHwImage {
                            override val rect = r
                            override val image = maybeHwImage
                        }
                    } else {
                        maybeHwImage
                    }
                    return result.copy(image = new, request = req, dataSource = result.dataSource)
                }
            }
            return result
        }
        return chain.proceed()
    }
}
