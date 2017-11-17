package com.tea.designview.canvas.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.tea.designview.R

/**
 * @desc
 * @author Tiany
 * @date  2017/11/8 0008
 */
class ArcView : View {

    private lateinit var mPaint: Paint
    private lateinit var mPaintRectF:Paint

    constructor(context: Context): super(context) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        initData()
    }

    private fun initData() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaintRectF = Paint(Paint.ANTI_ALIAS_FLAG)

        mPaint.apply {
            color = resources.getColor(R.color.colorPrimary)
            strokeWidth = 3f
            style = Paint.Style.FILL
        }

        mPaintRectF.apply {
            color = resources.getColor(R.color.colorAccent)
            strokeWidth = 3f
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val rectF = RectF(200f, 200f, 600f, 400f)
        canvas?.drawRect(rectF, mPaintRectF)
        canvas?.drawArc(rectF, 0f, 145f, true, mPaint)

        val rectF_ = RectF(200f, 600f, 600f, 800f)
        canvas?.drawRect(rectF_, mPaintRectF)
        canvas?.drawArc(rectF_, 0f, -145f, false, mPaint)
    }
}