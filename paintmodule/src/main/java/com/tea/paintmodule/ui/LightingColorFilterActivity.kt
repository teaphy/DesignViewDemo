package com.tea.paintmodule.ui

import android.graphics.PorterDuffXfermode
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tea.paintmodule.R
import com.teaphy.arc.base.BaseSingleActivity

import kotlinx.android.synthetic.main.activity_lighting_color_filter.*

class LightingColorFilterActivity : BaseSingleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_lighting_color_filter
    }

    override fun initTitle(): String {
        return "LightingColorFilter"
    }

    override fun setListener() {
        super.setListener()

        /*
         * 仅过滤绿色
         */
        btnFilterG.setOnClickListener {
            cmfv.setColorFilter(0xFFFF00FF.toInt(), 0x00000000)
        }

        /*
         * 仅映射红色
         */
        btnR.setOnClickListener {
            cmfv.setColorFilter(0xFFFFFFFF.toInt(), 0x00FF0000)
        }

        /*
         * 过滤绿色和映射红色
         */
        btnFilterGR.setOnClickListener {
            cmfv.setColorFilter(0xFFFF00FF.toInt(), 0x00FF0000)
        }
    }
}
