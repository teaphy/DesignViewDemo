package com.tea.designview.canvas.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.tea.designview.R

/**
 * @desc
 * @author Tiany
 * @date  2017/11/8 0008
 */
class CircleView: View {

    private lateinit var mPaint: Paint

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
        mPaint = Paint()
        mPaint.apply {
            isAntiAlias = true
            color = resources.getColor(R.color.colorPrimary)
            strokeWidth = 6f
            style = Paint.Style.FILL_AND_STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        val w = measuredWidth
        val h = measuredHeight

        canvas?.drawCircle(w/ 2.0f, h/ 2.0f, 200f, mPaint)
    }
}