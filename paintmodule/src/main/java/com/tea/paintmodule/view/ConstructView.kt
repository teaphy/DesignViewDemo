package com.tea.paintmodule.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @desc
 * @author Tiany
 * @date 2017/10/9 0009
 */
class ConstructView : View  {

    constructor(context: Context): super(context)

    constructor(context: Context , attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paintRed = Paint()
        paintRed.apply {
            color = resources.getColor(android.R.color.holo_red_dark)
            // 绘制时可以实现抗锯齿
            flags = Paint.ANTI_ALIAS_FLAG
            // 设置笔触：以路径结束，并不会超过它
            strokeCap = Paint.Cap.BUTT
            // 画笔的样式：只绘画轮廓
            style = Paint.Style.STROKE
            // 设置画笔宽度
            strokeWidth = 36F
        }

        val paintBlue = Paint(Paint.ANTI_ALIAS_FLAG)
        paintBlue.apply {
            flags = Paint.ANTI_ALIAS_FLAG
            color = resources.getColor(android.R.color.holo_blue_dark)
            strokeCap = Paint.Cap.BUTT
            strokeWidth = 36F
        }

        val paintRed_ = Paint(paintRed)

        canvas?.drawLine(240f, 240f, 640f, 240f, paintRed)
        canvas?.drawLine(240f, 320f, 640f, 320f, paintBlue)
        canvas?.drawLine(240f, 400f, 640f, 400f, paintRed_)
    }
}