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
class PaintTextAPIView : View {

    private val text: String = "yaξβбшㄎěǔぬ中"

    private val paintText = Paint()

    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paintText.apply {
            textSize = 96f
            strokeWidth = 3f
        }

        val baseLine = 128f

        // 获取View的宽度
        val width = width
        Log.i("123", "view的宽度: $width")

        val widthText = paintText.measureText(text)
        Log.i("123", "文本的宽度: $widthText")
        Log.i("123", "文本的个数: ${text.length}")

        val widthText_ = paintText.measureText(text, 0, 9)
        Log.i("123", "前9个字符的宽度: $widthText_")
        val measuredWidth = kotlin.FloatArray(1)
        val countBreak = paintText.breakText(text, true,  540f, measuredWidth)
        Log.i("123", "满足测量的条件的文本个数: $countBreak")
        Log.i("123", "measuredWidth: ${measuredWidth.toList()}")

        canvas?.drawText(text, 64f, baseLine, paintText)
    }
}