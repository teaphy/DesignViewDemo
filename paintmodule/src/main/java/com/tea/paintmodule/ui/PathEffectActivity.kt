package com.tea.paintmodule.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tea.paintmodule.R
import com.teaphy.arc.base.BaseSimpleActivity

class PathEffectActivity : BaseSimpleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_path_effect
    }

    override fun initTitle(): String {
        return "PathEffect"
    }


}
