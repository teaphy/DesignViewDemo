package com.tea.paintmodule.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.tea.paintmodule.R

/**
 * @desc
 * @author Tiany
 * @date 2017/10/16 0016
 */
class TextConfigView : View {

    lateinit var paintText: Paint
    private val paintDefault = Paint()

    private val text = "这是一段文本"
//    private val text = "This is a text "

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

        // 默认样式
        paintDefault.apply {
            textSize = 48f
        }

        // 相关文本设置画笔
        paintText = Paint(paintDefault)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 绘制默认样式的文本
        canvas?.drawText(text, 0f, 96f, paintDefault)

        // 绘制指定样式的文本
        canvas?.drawText(text, 0f, 144f, paintText)

    }

    fun reset() {
        paintText = Paint(paintDefault)
        invalidate()
    }


    /**
     * 设置字符间距
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun setLetterSpacing(letterSpacing: Float) {
        // 相关文本设置画笔
        paintText = Paint(paintDefault)

        Log.i("123", "默认文本间距：${paintDefault.letterSpacing}")

        paintText.letterSpacing = letterSpacing
        invalidate()
    }

    /**
     * 设置文本是否带有删除线
     */
    fun setStrikeThruText(strikeThruText: Boolean) {
        // 相关文本设置画笔
        paintText = Paint(paintDefault)

        paintText.isStrikeThruText = true
        invalidate()
    }

    /**
     * 设置画笔字体的比例因子
     */
    fun setTextScaleX(scaleX: Float) {
        // 相关文本设置画笔
        paintText = Paint(paintDefault)

        paintText.textScaleX = scaleX
        invalidate()
    }

    /**
     * 设置文本的偏移因子
     */
    fun setTextSkewX(skewX: Float) {
        // 相关文本设置画笔
        paintText = Paint(paintDefault)

        paintText.textSkewX = skewX
        invalidate()
    }

    /**
     * 是否绘制文本的下划线
     */
    fun setUnderlineText(underlineText: Boolean) {
        // 相关文本设置画笔
        paintText = Paint(paintDefault)

        paintText.isLinearText

        paintText.isUnderlineText = underlineText
        invalidate()
    }

    /**
     * 设置字体
     */
    fun setTypeface(typeface: Typeface) {
        // 相关文本设置画笔
        paintText = Paint(paintDefault)

        paintText.typeface = typeface
        invalidate()
    }
}