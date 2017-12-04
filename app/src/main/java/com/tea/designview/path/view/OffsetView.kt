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
class OffsetView : View {

    private lateinit var mPaint: Paint
    private lateinit var mPaintOs: Paint
    private lateinit var mPaintOsDst: Paint

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
        mPaintOs = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaintOsDst = Paint(Paint.ANTI_ALIAS_FLAG)

        mPaint.apply {
            color = resources.getColor(R.color.colorPrimary)
            strokeWidth = 3f
            style = Paint.Style.STROKE
        }
        mPaintOs.apply {
            color = resources.getColor(android.R.color.holo_red_dark)
            strokeWidth = 3f
            style = Paint.Style.STROKE
        }
        mPaintOsDst.apply {
            color = resources.getColor(android.R.color.black)
            strokeWidth = 3f
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val path = Path()
        val pathDst = Path()

        // path中，添加一个圆，其圆心为(300f, 300f),半径为200f
        path.addCircle(300f, 300f, 200f, Path.Direction.CW)
        canvas?.drawPath(path, mPaint)

        // pathDst中，添加一个矩形
        val rectF = RectF(50f, 50f, 400f, 400f)
        pathDst.addRect(rectF, Path.Direction.CW)

        // 将path偏移(100f, 100f),即x轴正向偏移100f，y轴方向偏移100f
        path.offset(100f, 100f, pathDst)
        canvas?.drawPath(path, mPaintOs)
        //
        canvas?.drawPath(pathDst, mPaintOsDst)
    }
}