package com.tea.designview

import com.tea.paintmodule.ui.PaintActivity
import com.teaphy.arc.adapter.AdapterSingleText
import com.teaphy.arc.base.BaseRecyclerViewActivity
import com.teaphy.arc.callback.OnItemClickCallback
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import com.tea.designview.canvas.CanvasActivity
import com.tea.designview.path.PathActivity
import java.nio.file.Path


class MainActivity : BaseRecyclerViewActivity<AdapterSingleText.MyHolder, AdapterSingleText>() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initTitle(): String {
        return getString(R.string.app_name)
    }

    override fun initAdapter() {
        mList.addAll(resources.getStringArray(R.array.arrayDesignColumn))
        mAdapter = AdapterSingleText(mList, object : OnItemClickCallback {
            override fun onClick(position: Int) {
                selectDesignModule(position)
            }

        })
    }

    private fun selectDesignModule(position: Int) {
        when (position) {
            0 -> startActivity<CanvasActivity>()
            1 -> startActivity<PathActivity>()
            2 -> startActivity<PaintActivity>()
            else -> toast("This is a invalid operation")
        }
    }

}
