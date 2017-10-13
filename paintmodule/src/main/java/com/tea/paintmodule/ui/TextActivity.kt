package com.tea.paintmodule.ui

import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tea.paintmodule.R
import com.teaphy.arc.base.BaseSingleActivity

class TextActivity : BaseSingleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_text
    }

    override fun initTitle(): String {
        return "Text"
    }

    override fun initData() {
        super.initData()

    }
}


