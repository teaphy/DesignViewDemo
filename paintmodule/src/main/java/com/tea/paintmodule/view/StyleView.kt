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
class StyleView : View {

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

        val paintStyle = Paint()

        paintStyle.apply {
            color = resources.getColor(android.R.color.holo_red_dark)
            // 绘制时可以实现抗锯齿
            flags = Paint.ANTI_ALIAS_FLAG
            // 设置笔触：以路径结束，并不会超过它
            strokeCap = Paint.Cap.BUTT
            strokeJoin = Paint.Join.ROUND
            // 设置画笔宽度
            strokeWidth = 36F
        }

        // 画笔的样式：只绘画轮廓
        paintStyle.style = Paint.Style.STROKE
        canvas?.drawRect(200f, 200f, 640f, 440f, paintStyle)

        // 连接的外缘以锐角相交
        paintStyle.style = Paint.Style.FILL
        canvas?.drawRect(200f, 540f, 640f, 780f, paintStyle)

        // 连接的外缘以圆弧相交
        paintStyle.style = Paint.Style.FILL_AND_STROKE
        canvas?.drawRect(200f, 880f, 640f, 1120f, paintStyle)

        canvas?.drawLine(200f, 0f, 200f, 1240f, paintDividing)
        canvas?.drawLine(640f, 0f, 640f, 1240f, paintDividing)
    }
}