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
class LinePathView : View {

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

        // 将起始点移动到(200f, 200f)
        path.moveTo(200f, 200f)
        // 从当前位置(200f, 200f)向(400f, 100f)绘制一条直线
        path.lineTo(400f, 100f)
        // 由当前位置向右下方绘制一条直线，终点坐标为(当前位置X坐标 + 400f， 当前位置Y坐标 + 100f)
        path.rLineTo(400f, 100f)

        canvas?.drawPath(path, mPaint)
    }
}