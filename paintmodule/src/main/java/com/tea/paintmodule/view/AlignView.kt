package com.tea.paintmodule.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.tea.paintmodule.R

/**
 * @desc
 * @author Tiany
 * @date 2017/10/16 0016
 */
class AlignView : View {

    lateinit var paintDefault: Paint
    lateinit var paintCenter: Paint
    lateinit var paintLeft: Paint
    lateinit var paintRight: Paint
    lateinit var paintLine:Paint

    private val text = "这是一段文本"

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
        paintDefault = Paint()

        paintDefault.apply {
            textSize = 48f
        }

        paintCenter = Paint(paintDefault)
        paintCenter.textAlign = Paint.Align.CENTER

        paintLeft = Paint(paintDefault)
        paintLeft.textAlign = Paint.Align.LEFT

        paintRight = Paint(paintDefault)
        paintRight.textAlign = Paint.Align.RIGHT

        paintLine = Paint()
        paintLine.apply {
            color = resources.getColor(R.color.colorLeading)
            strokeWidth = 3f
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawText(text, 144f, 72f, paintDefault)
        canvas?.drawText(text, 144f, 144f, paintCenter)
        canvas?.drawText(text, 144f, 216f, paintLeft)
        canvas?.drawText(text, 144f, 288f, paintRight)

        canvas?.drawLine(144f, 0f, 144f, 360f, paintLine)
    }
}