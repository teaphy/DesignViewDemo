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
class OpView : View {

    private lateinit var mPaint: Paint
    private lateinit var mPaintCircle: Paint

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
        mPaintCircle = Paint(Paint.ANTI_ALIAS_FLAG)

        mPaint.apply {
            color = resources.getColor(R.color.colorPrimary)
            strokeWidth = 3f
            style = Paint.Style.FILL
        }

        mPaintCircle.apply {
            color = resources.getColor(android.R.color.holo_red_dark)
            strokeWidth = 3f
            style = Paint.Style.STROKE
        }

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val path1 = Path()
        val path2 = Path()
        val path = Path()

        // 添加顺时针的圆
        path1.addCircle(400f, 400f, 200f, Path.Direction.CW)
        // 添加顺时针的圆
        path2.addCircle(700f, 400f, 200f, Path.Direction.CW)
        // path1减去path1与path2相交的部分后
        // 运算结果为path1所剩余的部分
        // path1 - path1 ∩ path2
//        path.op(path1, path2, Path.Op.DIFFERENCE)
        // path2减去path2与path1相交的部分
        // 运算结果为path2所剩余的部分
        // path2 - path1 ∩ path2
        path.op(path1, path2, Path.Op.REVERSE_DIFFERENCE)
        // Path1与Path2相交的部分
        // path1 ∩ path2
//        path.op(path1, path2, Path.Op.INTERSECT)
        // path1与path2的并集
        // path1 ∪ path2
//        path.op(path1, path2, Path.Op.UNION)
        // path1与path2的并集减去path1与path2的交集
        // (path1 ∪ path2) - (path1 ∩ path2)
//        path.op(path1, path2, Path.Op.XOR)

        canvas?.drawPath(path, mPaint)
        canvas?.drawPath(path1, mPaintCircle)
        canvas?.drawPath(path2, mPaintCircle)
    }
}