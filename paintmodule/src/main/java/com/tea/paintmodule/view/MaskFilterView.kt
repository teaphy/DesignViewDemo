package com.tea.paintmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tea.paintmodule.R

/**
 * @desc
 * @author Tiany
 * @date  2017/10/23 0023
 */
class MaskFilterView : View {

    private lateinit var mPaint: Paint
    private lateinit var mPaintText: Paint
    private lateinit var mBitMap: Bitmap
    private val mText = "看我，模糊不模糊!"

    constructor(context: Context) : super(context) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initData()
    }

    private fun initData() {

        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

        mBitMap = BitmapFactory.decodeResource(resources, R.mipmap.ic_sea)

        mPaintText = Paint(Paint.ANTI_ALIAS_FLAG)

        mPaintText.apply {
            color = resources.getColor(R.color.colorCommon)
            textSize = 96f
            strokeWidth = 16f
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawBitmap(mBitMap, 48f, 48f, mPaint)

        canvas?.drawText(mText, 48f, 480f, mPaintText)
    }

    /**
     * 设置BlurMaskFilter
     */
    fun setBlurMaskFilter(radius: Float, style: BlurMaskFilter.Blur) {
        val maskFilter = BlurMaskFilter(radius, style)

        mPaint.maskFilter = maskFilter
        mPaintText.maskFilter = maskFilter
        invalidate()
    }

    /**
     * 设置 EmbossMaskFilter
     */
    fun setEmbossMaskFilter(direction: FloatArray, ambient: Float, specular: Float, blurRadius: Float) {

        val maskFilter = EmbossMaskFilter(direction, ambient, specular, blurRadius)
        mPaint.maskFilter = maskFilter
        mPaintText.maskFilter = maskFilter
        invalidate()
    }

    fun resetMaskFilter() {
        mPaint.maskFilter = null
        mPaintText.maskFilter = null
        invalidate()
    }
}