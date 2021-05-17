package com.alexandernsalim.moviecatalogue.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import androidx.annotation.FloatRange
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.TransformationUtils
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.PAINT_FLAGS
import java.nio.charset.Charset
import java.security.MessageDigest

class TopRightCropTransformation(
    val context: Context,
    @FloatRange(from = 0.0, to = 1.0) val xPercentage: Float = 0.0f,
    @FloatRange(from = 0.0, to = 1.0) val yPercentage: Float = 0.0f
) : BitmapTransformation() {

    companion object {
        private const val id = "com.alexandernsalim.moviecatalogue.util.TopRightCropTransformation"
        private val idBytes = id.toByteArray(Charset.forName("UTF-8"))
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(idBytes)
    }

    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap? {
        val toReuse =
            pool[outWidth, outHeight, if (toTransform.config != null) toTransform.config else Bitmap.Config.ARGB_8888]
        val transformed: Bitmap? =
            crop(toReuse, toTransform, outWidth, outHeight, xPercentage, yPercentage)

        if (toReuse != transformed) {
            pool.put(toReuse)
        }

        return transformed
    }

    private fun crop(
        recycled: Bitmap?,
        toCrop: Bitmap?,
        width: Int,
        height: Int,
        xPercentage: Float,
        yPercentage: Float
    ): Bitmap? {
        if (toCrop == null) {
            return null
        } else if (toCrop.width == width && toCrop.height == height) {
            return toCrop
        }

        val scale: Float
        var dx = 0f
        var dy = 0f
        val m = Matrix()

        if (toCrop.width * height > width * toCrop.height) {
            scale = height.toFloat() / toCrop.height.toFloat()
            dx = width - toCrop.width * scale
            dx *= xPercentage
        } else {
            scale = width.toFloat() / toCrop.width.toFloat()
            dy = height - toCrop.height * scale
            dy *= yPercentage
        }
        m.setScale(scale, scale)
        m.postTranslate((dx + 0.5f), (dy + 0.5f))

        val result: Bitmap = recycled ?: Bitmap.createBitmap(width, height, getSafeConfig(toCrop)!!)

        TransformationUtils.setAlpha(toCrop, result)

        val canvas = Canvas(result)
        val paint = Paint(PAINT_FLAGS)

        canvas.drawBitmap(toCrop, m, paint)

        return result
    }

    private fun getSafeConfig(bitmap: Bitmap): Bitmap.Config? {
        return if (bitmap.config != null) bitmap.config else Bitmap.Config.ARGB_8888
    }
}