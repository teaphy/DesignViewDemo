package com.tea.paintmodule.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.tea.paintmodule.R

/**
 * @desc
 * @author Tiany
 * @date 2017/10/13 0013
 */
class FontMetricsView : View {

    private val text1: String = "yaξβбшㄎěǔぬ中"

    val paintText = Paint()
    val paintLine = Paint()

    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paintText.apply {
            textSize = 96f
            strokeWidth = 3f
        }

        // FontMetrics对象
        val fontMetrics = paintText.fontMetricsInt
        val topY = fontMetrics.top
        val ascentY = fontMetrics.ascent
        val descentY = fontMetrics.descent
        val bottomY = fontMetrics.bottom
        val leading = fontMetrics.leading

        Log.i("123", "topY: $topY")
        Log.i("123", "ascentY: $ascentY")
        Log.i("123", "descentY: $descentY")
        Log.i("123", "bottomY: $bottomY")
        Log.i("123", "leading: $leading")

        val baseLine = 128f

        val widthText = paintText.measureText(text1)

        canvas?.drawText(text1, 64f, baseLine, paintText)

        paintLine.strokeWidth = 3f

        paintLine.color = resources.getColor(android.R.color.holo_red_dark)
        canvas?.drawLine(0f, baseLine, 128f + widthText, baseLine, paintLine)

        paintLine.color = resources.getColor(R.color.colorTop)
        canvas?.drawLine(0f, topY + baseLine, 128f + widthText, topY + baseLine, paintLine)

        paintLine.color = resources.getColor(R.color.colorAscent)
        canvas?.drawLine(0f, ascentY + baseLine, 128f + widthText, ascentY + baseLine, paintLine)

        paintLine.color = resources.getColor(R.color.colorDescent)
        canvas?.drawLine(0f, descentY + baseLine, 128f + widthText, descentY + baseLine, paintLine)

        paintLine.color = resources.getColor(R.color.colorBottom)
        canvas?.drawLine(0f, bottomY + baseLine, 128f + widthText, bottomY + baseLine, paintLine)


        paintLine.strokeWidth = leading.toFloat()
        paintLine.color = resources.getColor(R.color.colorLeading)
        canvas?.drawLine(0f, bottomY.toFloat(), 128f + widthText, bottomY.toFloat(), paintLine)

    }
}