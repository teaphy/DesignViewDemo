package com.tea.paintmodule.ui

import android.graphics.BlurMaskFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.tea.paintmodule.R
import com.teaphy.arc.base.BaseSimpleActivity

import kotlinx.android.synthetic.main.activity_mask_filter.*

class MaskFilterActivity : BaseSimpleActivity() {

    var mBlurStyle = BlurMaskFilter.Blur.NORMAL
    var mBlurRadius = 0f

    var mDirectionX = 0f
    var mDirectionY = 0f
    var mDirectionZ = 0f
    var mAmbient = 0f
    var mSpecular = 0f
    var mEBlurRadius = 0f

    override fun getLayoutId(): Int {
        return R.layout.activity_mask_filter
    }

    override fun initTitle(): String {
        return "MaskFilter"
    }


    override fun setListener() {
        super.setListener()

        rgMaskFilter.setOnCheckedChangeListener { _, checkedId ->

            when (checkedId) {
                R.id.rbNormal -> maskAvailable(true, false, false)
                R.id.rbBlur -> maskAvailable(false, true, false)
                R.id.rbEmboss -> maskAvailable(false, false, true)
            }
        }

        rgBlurStyle.setOnCheckedChangeListener { _, checkedId ->

            when (checkedId) {
                R.id.rbBlurNormal -> setBlurStyle(BlurMaskFilter.Blur.NORMAL)
                R.id.rbBlurINNER -> setBlurStyle(BlurMaskFilter.Blur.INNER)
                R.id.rbBlurOUTER -> setBlurStyle(BlurMaskFilter.Blur.OUTER)
                R.id.rbBlurSOLID -> setBlurStyle(BlurMaskFilter.Blur.SOLID)
            }
        }

        sbBlurRadius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvBlurRadius.text = progress.toString()
                mBlurRadius = progress.toFloat()

                if (mBlurRadius > 0) {
                    mfv.setBlurMaskFilter(mBlurRadius, mBlurStyle)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        sbDirectionX.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mDirectionX = progress.toFloat()
                tvDirectionX.text = progress.toString()
                setEmboss()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        sbDirectionY.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mDirectionY = progress.toFloat()
                tvDirectionY.text = progress.toString()
                setEmboss()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        sbDirectionZ.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mDirectionZ = progress.toFloat()

                tvDirectionZ.text = progress.toString()

                setEmboss()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        sbAmbient.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mAmbient = progress.toFloat() / 100

                tvAmbient.text = mAmbient.toString()

                setEmboss()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        sbSpecular.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mSpecular = progress.toFloat() / 100

                tvSpecular.text = mSpecular.toString()

                setEmboss()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        sbEBlurRadius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mEBlurRadius = progress.toFloat() / 100

                tvEBlurRadius.text = mEBlurRadius.toString()

                setEmboss()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })


    }

    /**
     * 设置MaskFilter是否可用
     */
    private fun maskAvailable(isNormal: Boolean, isBlur: Boolean, isEmboss: Boolean) {

        if (isNormal) {
            mfv.resetMaskFilter()
        }

        llBlur.visibility = if (isBlur) View.VISIBLE else View.GONE
        llEmboss.visibility = if (isEmboss) View.VISIBLE else View.GONE
    }

    /**
     * 设置BlurMaskFilter的阴影类型
     */
    private fun setBlurStyle(style: BlurMaskFilter.Blur) {

        mBlurStyle = style

        if (mBlurRadius > 0) {
            mfv.setBlurMaskFilter(mBlurRadius, mBlurStyle)
        }
    }

    private fun setEmboss() {
        mfv.setEmbossMaskFilter(floatArrayOf(mDirectionX, mDirectionY, mDirectionZ), mAmbient, mSpecular, mEBlurRadius)
    }
}
