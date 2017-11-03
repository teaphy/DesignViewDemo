package com.tea.paintmodule.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tea.paintmodule.R

/**
 * @desc
 * @author Tiany
 * @date  2017/10/24 0024
 */
class ShaderView : View {

    /**
     * 0: DrawCircle
     * 1: BitmapShader
     * 2. LinearGradient
     */
    var typeShader: Int = 0 // 0
        set(value) {
            field = value
            invalidate()
        }

    var mTileX: Shader.TileMode = Shader.TileMode.CLAMP
        set(value) {
            field = value
            invalidate()
        }
    var mTileY: Shader.TileMode = Shader.TileMode.CLAMP
        set(value) {
            field = value
            invalidate()
        }


    private val mPaint: Paint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG)
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        when (typeShader) {
            0 -> drawCircle(canvas)
            1 -> drawBitmapShader(canvas)
            2 -> drawLinearGradientShader(canvas)
            else -> drawCircle(canvas)

        }

    }

    private fun drawCircle(canvas: Canvas?) {


        // 原图
        val bmp: Bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_mokey_180)

        val w = bmp.width.toFloat()
        val h = bmp.height.toFloat()
        val radius = if (w <= h) w / 2 else h / 2

        // 以Bitmap作为纹理创建BitmapShader
        val bitMapShader = BitmapShader(bmp, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)

        mPaint.shader = bitMapShader

        canvas?.drawCircle(radius, radius, radius, mPaint)

//        val paintText = Paint(Paint.ANTI_ALIAS_FLAG)
//        paintText.apply {
//            textSize = 96f
//            strokeWidth = 36f
//            shader = bitMapShader
//        }
//
//        canvas?.drawText("这是一只猴", 0f , radius * 3, paintText)
    }

    private fun drawBitmapShader(canvas: Canvas?) {
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_mokey_180)

        val bitMapShader = BitmapShader(bitmap, mTileX, mTileY)

        mPaint.shader = bitMapShader

        canvas?.drawRect(0f, 0f, measuredWidth.toFloat(), measuredHeight.toFloat(), mPaint)
    }

    private fun drawLinearGradientShader(canvas: Canvas?) {
        val widthView: Int = measuredWidth
        val heightView: Int = measuredHeight

        val colorResA = resources.getColor(android.R.color.holo_red_dark)
        val colorResB = resources.getColor(android.R.color.holo_blue_dark)
        val colorResC = resources.getColor(android.R.color.black)
        val colorResD = resources.getColor(android.R.color.holo_green_dark)

        val colorArray = intArrayOf(colorResA, colorResB, colorResC, colorResD)
        val positionArray = floatArrayOf(0.0f, 0.3f, 0.4f, 1.0f)

        val lgsShader = LinearGradient(0f, 0f, widthView / 4f, 0f,
                colorArray, positionArray, Shader.TileMode.REPEAT)

        mPaint.shader = lgsShader

        canvas?.drawRect(0f, 0f, measuredWidth.toFloat(), measuredHeight.toFloat(), mPaint)
    }
}