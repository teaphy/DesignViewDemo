package com.tea.paintmodule.view

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
class ColorView : View {

    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paintDefault = Paint()
        paintDefault.apply {
            // 绘制时可以实现抗锯齿
            flags = Paint.ANTI_ALIAS_FLAG
            // 设置笔触：以路径结束，并不会超过它
            strokeCap = Paint.Cap.BUTT
            // 画笔的样式：只绘画轮廓
            style = Paint.Style.STROKE
            // 设置画笔宽度
            strokeWidth = 36F
        }

        // Color
        val paintRed = Paint(Paint.ANTI_ALIAS_FLAG)
        paintRed.apply {
            flags = Paint.ANTI_ALIAS_FLAG
            color = resources.getColor(android.R.color.holo_red_dark)
            strokeCap = Paint.Cap.BUTT
            strokeWidth = 36F
        }

        // Alpha
        val paintAlpha = Paint(paintRed)
        paintAlpha.apply {
            alpha = 80
        }

        // ARGB
        val paintArgb = Paint(Paint.ANTI_ALIAS_FLAG)
        paintArgb.apply {
            flags = Paint.ANTI_ALIAS_FLAG
            setARGB(255, 128, 0, 128)
            strokeCap = Paint.Cap.BUTT
            strokeWidth = 36F
        }

        canvas?.drawLine(240f, 240f, 640f, 240f, paintDefault)
        canvas?.drawLine(240f, 320f, 640f, 320f, paintRed)
        canvas?.drawLine(240f, 400f, 640f, 400f, paintAlpha)
        canvas?.drawLine(240f, 480f, 640f, 480f, paintArgb)
    }
}