package com.tea.paintmodule.ui

import android.graphics.BlurMaskFilter
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.TextPaint
import com.tea.paintmodule.R
import com.teaphy.arc.base.BaseSimpleActivity
import kotlinx.android.synthetic.main.activity_text.*

class TextActivity : BaseSimpleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_text
    }

    override fun initTitle(): String {
        return "Text"
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun setListener() {
        super.setListener()

        btnReset.setOnClickListener {
            tcv.reset()
        }

        btnLetterSpacing.setOnClickListener {
            tcv.setLetterSpacing(1f)
        }

        btnStrikeThruText.setOnClickListener {
            tcv.setStrikeThruText(true)
        }

        btnTextScaleX.setOnClickListener {
            tcv.setTextScaleX(2f)
    }

        btnTextSkewX.setOnClickListener {
            tcv.setTextSkewX(-1f)
        }

        btnUnderlineText.setOnClickListener {
            tcv.setUnderlineText(true)
        }


        btnTypeface.setOnClickListener {
            val typeface = Typeface.defaultFromStyle(Typeface.ITALIC or Typeface.BOLD)
            tcv.setTypeface(typeface)
        }
    }
}


