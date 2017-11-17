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
class OvalPathView : View {

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

        val pathOval = Path()

        val rectFCCW = RectF(100f, 100f, 500f, 300f)
        val rectFCW = RectF(50f, 50f, 600f, 400f)

        // 添加一个逆时针的椭圆
        pathOval.addOval(rectFCCW, Path.Direction.CCW)
        // 添加一个顺时针的椭圆
        pathOval.addOval(rectFCW, Path.Direction.CW)

        canvas?.drawPath(pathOval, mPaint)
    }
}