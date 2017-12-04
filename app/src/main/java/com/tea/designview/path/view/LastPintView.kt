package com.tea.designview.path.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.tea.designview.R

/**
 * @desc
 * @author Tiany
 * @date  2017/11/8 0008
 */
class LastPintView : View {

    private lateinit var mPaint: Paint
    private lateinit var mPaintLast: Paint

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
        mPaintLast = Paint(Paint.ANTI_ALIAS_FLAG)

        mPaint.apply {
            color = resources.getColor(R.color.colorPrimary)
            strokeWidth = 5f
            style = Paint.Style.STROKE
        }
        mPaintLast.apply {
            color = resources.getColor(android.R.color.holo_red_dark)
            strokeWidth = 5f
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val path = Path()

        path.moveTo(100f, 100f)
        // 向(300f, 300f)绘制一条
        path.lineTo(300f, 300f)
        // 向(500f, 100f)绘制一条
        // 此时轮廓的最后一个点为(500f, 100f)
        path.lineTo(500f, 100f)

        canvas?.drawPath(path, mPaint)

        path.setLastPoint(700f, 200f)
        canvas?.drawPath(path, mPaintLast)
    }
}