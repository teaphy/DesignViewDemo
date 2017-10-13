package com.tea.paintmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tea.paintmodule.R
import android.graphics.ColorMatrixColorFilter
import android.graphics.ColorMatrix


/**
 * @desc 颜色矩阵过滤器
 * @author Tiany
 * @date 2017/10/10 0010
 */
class ColorMatrixFilterView : View {

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

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 设置画笔颜色过滤器
        mPaintFilter.colorFilter = ColorMatrixColorFilter(mColorMatrix)
        // 绘制处理后的图片
        canvas?.drawBitmap(mBitMap, 0f, 0f, mPaintFilter)
    }

    /**
     *  设置颜色矩阵的值
     */
    fun setColorMatrix(src: FloatArray) {
        mColorMatrix.set(src)
        invalidate()
    }

    /**
     *  设置颜色矩阵的值
     */
    fun setColorMatrix(src: ColorMatrix) {
        mColorMatrix.set(src)
        invalidate()
    }

    /**
     *  重置颜色矩阵
     *
     *   [ 1 0 0 0 0   - red vector
     *     0 1 0 0 0   - green vector
     *     0 0 1 0 0   - blue vector
     *     0 0 0 1 0 ] - alpha vector
     */
    fun resetColorMatrix() {
        mColorMatrix.reset()
        invalidate()
    }

    fun postConcat(postMatrix: ColorMatrix ) {
        mColorMatrix.postConcat(postMatrix)
        invalidate()
    }

    fun preConcat(preMatrix: ColorMatrix ) {
        mColorMatrix.preConcat(preMatrix)
        invalidate()
    }

    fun setConcat(matrixA: ColorMatrix, matrixB: ColorMatrix) {
        mColorMatrix.setConcat(matrixA, matrixB)
        invalidate()
    }

    fun setRotate( axis: Int, degrees: Float) {
        mColorMatrix.setRotate(axis, degrees)
        invalidate()
    }
}