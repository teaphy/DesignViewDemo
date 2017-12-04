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
class ConvexView : View {

    private lateinit var mPaint: Paint

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

        mPaint.apply {
            color = resources.getColor(R.color.colorPrimary)
            strokeWidth = 6f
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val path = Path()
        val pathA = Path()

        val rectFCCW = RectF(100f, 100f, 500f, 300f)

        // path中添加一个逆时针的矩形
        path.addRect(rectFCCW, Path.Direction.CCW)
        // pathA中添加一个圆
        pathA.addCircle(300f, 300f, 100f, Path.Direction.CCW)
        // 将path中的数据替换为pathA的数据
        path.set(pathA)

        canvas?.drawPath(path, mPaint)
    }
}