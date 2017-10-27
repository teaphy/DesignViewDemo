package com.tea.paintmodule.ui

import android.graphics.LightingColorFilter
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.tea.paintmodule.R
import com.tea.paintmodule.view.*
import com.teaphy.arc.base.BaseSimpleActivity

import kotlinx.android.synthetic.main.activity_paint.*
import org.jetbrains.anko.startActivity

class PaintActivity : BaseSimpleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_paint
    }

    override fun initTitle(): String {
        return getString(R.string.paint_name)
    }

    override fun setListener() {
        super.setListener()

        btnConstruct.setOnClickListener {
            val view = ConstructView(this)

            addDesignView(view)
        }

        btnCap.setOnClickListener {
            val view = CapView(this)
            addDesignView(view)
        }

        btnJoin.setOnClickListener {
            val view = JoinView(this)
            addDesignView(view)
        }

        btnStyle.setOnClickListener {
            val view = StyleView(this)
            addDesignView(view)
        }

        btnColor.setOnClickListener {
            val view = ColorView(this)
            addDesignView(view)
        }

        btnColorMF.setOnClickListener {
            startActivity<ColorMatrixFilterActivity>()
        }

        btnLcf.setOnClickListener {
            startActivity<LightingColorFilterActivity>()
        }

        btnPdcf.setOnClickListener {
            startActivity<PorterDuffColorFilterActivity>()
        }

        btnXf.setOnClickListener {
            startActivity<XfermodeActivity>()
        }

        btnText.setOnClickListener {
            startActivity<TextActivity>()
        }

        btnMaskFilter.setOnClickListener {
            startActivity<MaskFilterActivity>()
        }

        btnPathEffect.setOnClickListener {
            startActivity<PathEffectActivity>()
        }

        btnShader.setOnClickListener {
            startActivity<ShaderActivity>()
        }
    }

    private fun addDesignView(view: View) {
        llContent.removeAllViews()
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        view.layoutParams  = params
        llContent.addView(view)
    }
}
