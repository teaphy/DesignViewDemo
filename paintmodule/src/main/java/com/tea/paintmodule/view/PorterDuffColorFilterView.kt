package com.tea.paintmodule.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tea.paintmodule.R

/**
 * @desc 颜色矩阵过滤器
 * @author Tiany
 * @date 2017/10/10 0010
 */
class PorterDuffColorFilterView : View {

    lateinit var mBitMap: Bitmap
    lateinit var mPaintFilter: Paint
    lateinit var mColorMatrix: ColorMatrix

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
        mPaintFilter = Paint()
        // 创建BitMap
        mBitMap = BitmapFactory.decodeResource(resources, R.mipmap.ic_sea)

        // 新建颜色矩阵对象
        mColorMatrix = ColorMatrix()

        // 设置画笔颜色过滤器
        mPaintFilter.colorFilter = PorterDuffColorFilter(0xFF00FF00.toInt(), PorterDuff.Mode.DST_OVER)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        // 绘制处理后的图片
        canvas?.drawBitmap(mBitMap, 0f, 0f, mPaintFilter)
    }


}