package com.tea.paintmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tea.paintmodule.R

/**
 * @desc
 * @author Tiany
 * @date  2017/10/23 0023
 */
class PathEffectView : View{
    private lateinit var mPaint: Paint

    private var mPhase = 0f

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
            color = resources.getColor(android.R.color.holo_red_dark)
            strokeWidth = 3f
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val path = Path()
        path.lineTo(100f, 100f)
        path.lineTo(200f, 0f)
        path.lineTo(300f, 100f)
        path.lineTo(400f, 0f)
        path.lineTo(500f, 100f)

        mPaint.pathEffect = null
        canvas?.drawPath(path, mPaint)

        path.offset(0f, 120f)
        val cornerPathEffect = CornerPathEffect(64f)
        mPaint.pathEffect = cornerPathEffect
        canvas?.drawPath(path, mPaint)

        path.offset(0f, 120f)
        val dashPathEffect = DashPathEffect(floatArrayOf(60f, 60f), 0f)
        mPaint.pathEffect = dashPathEffect
        canvas?.drawPath(path, mPaint)

        path.offset(0f, 120f)
        val dashPathEffectPhase = DashPathEffect(floatArrayOf(30f, 30f), 0f)
        mPaint.pathEffect = dashPathEffectPhase
        canvas?.drawPath(path, mPaint)

        path.offset(0f, 120f)
        val composePathEffect = ComposePathEffect(cornerPathEffect, dashPathEffect)
        mPaint.pathEffect = composePathEffect
        canvas?.drawPath(path, mPaint)

	    path.offset(0f, 120f)
	    val sumPathEffect = SumPathEffect(cornerPathEffect, dashPathEffect)
	    mPaint.pathEffect = sumPathEffect
	    canvas?.drawPath(path, mPaint)


        path.offset(0f, 120f)
        val discretePathEffect = DiscretePathEffect(96f, 16f)
        mPaint.pathEffect = discretePathEffect
        canvas?.drawPath(path, mPaint)



        val shape = Path()
        shape.lineTo(0f, 30f)
        shape.lineTo(30f, 30f)
        shape.lineTo(0f, 0f)

        path.offset(40f, 240f)
        val pathDashPathEffect = PathDashPathEffect(shape, 60f, 0f, PathDashPathEffect.Style.ROTATE)
        mPaint.pathEffect = pathDashPathEffect
        canvas?.drawPath(path, mPaint)

        path.offset(0f, 160f)
        val pathDashPathEffect1 = PathDashPathEffect(shape, 60f, 0f, PathDashPathEffect.Style.MORPH)
        mPaint.pathEffect = pathDashPathEffect1
        canvas?.drawPath(path, mPaint)


        path.offset(0f, 160f)
        val pathDashPathEffect2 = PathDashPathEffect(shape, 60f, 0f, PathDashPathEffect.Style.TRANSLATE)
        mPaint.pathEffect = pathDashPathEffect2
        canvas?.drawPath(path, mPaint)


        mPhase++

        if (mPhase > 40f) {
            mPhase = 0f
        }

        invalidate()
    }
}