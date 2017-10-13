package com.tea.paintmodule.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.tea.paintmodule.R
import com.teaphy.arc.base.BaseSingleActivity

class PorterDuffColorFilterActivity : BaseSingleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_porter_duff_color_filter
    }

    override fun initTitle(): String {
        return "PorterDuffColorFilterActivity"
    }

}
