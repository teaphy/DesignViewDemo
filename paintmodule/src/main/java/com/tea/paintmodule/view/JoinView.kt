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
class JoinView : View {

    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paintJoin = Paint()

        paintJoin.apply {
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

        // 连接的外缘以直线相交
        paintJoin.strokeJoin = Paint.Join.BEVEL
        canvas?.drawRect(200f, 200f, 640f, 440f, paintJoin)

        // 连接的外缘以锐角相交
        paintJoin.strokeJoin = Paint.Join.MITER
        canvas?.drawRect(200f, 540f, 640f, 780f, paintJoin)

        // 连接的外缘以圆弧相交
        paintJoin.strokeJoin = Paint.Join.ROUND
        canvas?.drawRect(200f, 880f, 640f, 1120f, paintJoin)
    }
}