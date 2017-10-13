package com.tea.paintmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tea.paintmodule.R

/**
 * @desc
 * @author Tiany
 * @date 2017/10/12 0012
 */
class XfermodeView : View {

    lateinit var mPaint: Paint
    // 源图
    lateinit var mSource: Bitmap
    // 目标图
    lateinit var mDst: Bitmap
    // 过渡模式
    var mXfermode: Xfermode? = null


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
        // 创建画笔
        mPaint = Paint()
        mPaint.let {  }
        // 创建BitMap - 源图
        mSource = BitmapFactory.decodeResource(resources, R.mipmap.ic_source)
        // 创建BitMap - 目标图
        mDst = BitmapFactory.decodeResource(resources, R.mipmap.ic_dst)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /*
         * 将绘制操作保存到新的图层（更官方的说法应该是离屏缓存）
         */
        val sc = canvas?.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)

        // 先绘制dis目标图
        canvas?.drawBitmap(mDst, 0f, 0f, mPaint)

        // 设置混合模式
        mPaint.xfermode = mXfermode

        // 再绘制src源图
        canvas?.drawBitmap(mSource, 0f, 0f, mPaint)

        // 还原混合模式
        mPaint.xfermode = null

        // 还原画布
        canvas?.restoreToCount(sc!!)
    }

    /**
     * 设置混合模式
     */
    fun setXfermode(mode: PorterDuff.Mode) {
        mXfermode =  PorterDuffXfermode(mode)
        invalidate()
    }
}