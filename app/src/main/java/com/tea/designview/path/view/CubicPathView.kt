package com.tea.designview.path.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tea.designview.R

/**
 * @desc
 * @author Tiany
 * @date  2017/11/8 0008
 */
class CubicPathView : View {

    private lateinit var mPaint: Paint
    private lateinit var mPaintLine: Paint

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
        mPaintLine = Paint(Paint.ANTI_ALIAS_FLAG)

        mPaint.apply {
            color = resources.getColor(R.color.colorPrimary)
            strokeWidth = 6f
            style = Paint.Style.STROKE
        }

        mPaintLine.apply {
            color = resources.getColor(android.R.color.holo_red_dark)
            strokeWidth = 3f
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val path = Path()
        val pathLine = Path()

        pathLine.moveTo(200f, 200f)
        pathLine.lineTo(400f, 500f)
        pathLine.lineTo(600f, 500f)
        pathLine.lineTo(800f, 200f)

        // 起始点为(200f, 200f)
        path.moveTo(200f, 200f)
        // 控制点P1为(400f, 500f)
        // 控制点P2为(600f, 500f)
        // 结束点P2为(800f, 200f)
        path.cubicTo(400f, 500f, 600f, 500f, 800f, 200f)

        canvas?.drawPath(pathLine, mPaintLine)
        canvas?.drawPath(path, mPaint)
    }
}