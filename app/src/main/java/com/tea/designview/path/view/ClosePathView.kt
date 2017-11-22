package com.tea.designview.path.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.tea.designview.R

/**
 * @desc
 * @author Tiany
 * @date  2017/11/8 0008
 */
class ClosePathView : View {

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
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

        mPaint.apply {
            color = resources.getColor(R.color.colorPrimary)
            strokeWidth = 6f
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val path = Path()

        // 设置起始位置为(200f, 200f)
        path.moveTo(200f, 200f)
        // 从当前位置(200f, 200f)向(400f, 100f)绘制一条直线
        path.lineTo(400f, 100f)
        // 从(400f, 100f)向(600f, 400f)绘制一条直线
        path.lineTo(600f, 400f)
        // close的作用是封闭当前的自图形
        // 等价于等价于 path.lineTo(200f, 200f)
        path.close()

        val bounds = RectF()

        path.incReserve(2)

        path.computeBounds(bounds, false)
        // bounds: RectF(200.0, 100.0, 600.0, 400.0)
        Log.i("teaphy", "bounds: $bounds")

        canvas?.drawPath(path, mPaint)
    }
}