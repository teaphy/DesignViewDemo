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
 * @date 2017/10/9 0009
 */
class CapView : View {
    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paintDividing = Paint()

        paintDividing.apply {
            color = resources.getColor(R.color.colorDc)
            // 绘制时可以实现抗锯齿
            flags = Paint.ANTI_ALIAS_FLAG
            // 设置笔触：以路径结束，并不会超过它
            strokeCap = Paint.Cap.BUTT
            // 画笔的样式：只绘画轮廓
            style = Paint.Style.STROKE
            // 设置画笔宽度
            strokeWidth = 3F
        }

        val paintButt = Paint()
        paintButt.apply {
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

        val paintRound = Paint(paintButt)
        paintRound.apply {
            color = resources.getColor(android.R.color.holo_blue_light)
            // 笔触是半圆形的，其中心为路径的结束位置
            strokeCap = Paint.Cap.ROUND
        }

        val paintSquare = Paint(paintButt)
        paintSquare.apply {
            color = resources.getColor(android.R.color.holo_green_light)
            // 笔触为方形，其中心为路径的结束位置
            strokeCap = Paint.Cap.SQUARE
        }


        canvas?.drawLine(240f, 240f, 640f, 240f, paintButt)
        canvas?.drawLine(240f, 320f, 640f, 320f, paintRound)
        canvas?.drawLine(240f, 400f, 640f, 400f, paintSquare)

        // 绘制分割线
        canvas?.drawLine(240f, 0f, 240f, 720f, paintDividing)
        canvas?.drawLine(640f, 0f, 640f, 720f, paintDividing)
    }
}