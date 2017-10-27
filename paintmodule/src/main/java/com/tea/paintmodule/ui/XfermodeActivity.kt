package com.tea.paintmodule.ui

import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tea.paintmodule.R
import com.teaphy.arc.base.BaseActivity
import com.teaphy.arc.base.BaseSimpleActivity

import kotlinx.android.synthetic.main.activity_xfermode.*
import org.jetbrains.anko.toast

class XfermodeActivity : BaseSimpleActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_xfermode
    }

    override fun initTitle(): String {
        return "Xfermode"
    }

    override fun setListener() {
        super.setListener()

        btnSource.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.SRC)
        }

        btnSRC_OVER.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.SRC_OVER)
        }

        btnSRC_IN.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.SRC_IN)
        }

        btnSRC_OUT.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.SRC_OUT)
        }

        btnSRC_ATOP.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.SRC_ATOP)
        }

        btnDST.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.DST)
        }

        btnDST_OVER.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.DST_OVER)
        }

        btnDST_IN.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.DST_IN)
        }

        btnDST_OUT.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.DST_OUT)
        }

        btnDST_ATOP.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.DST_ATOP)
        }

        btnCLEAR.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.CLEAR)
        }

        btnXOR.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.XOR)
        }

        btnDARKEN.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.DARKEN)
        }

        btnLIGHTEN.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.LIGHTEN)
        }

        btnMULTIPLY.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.MULTIPLY)
        }

        btnSCREEN.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.SCREEN)
        }

        btnOVERLAY.setOnClickListener {
            xfv.setXfermode(PorterDuff.Mode.OVERLAY)
        }
    }
}
