package com.tea.designview.canvas

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.tea.designview.R
import com.tea.designview.apapter.AdapterFragment
import com.tea.designview.base.PageFragment
import com.teaphy.arc.base.BaseSimpleActivity

import kotlinx.android.synthetic.main.activity_canvas.*

class CanvasActivity : BaseSimpleActivity() {

    private val mListFragment = mutableListOf<Fragment>()
    private val mListTitle = mutableListOf<String>()
    private val mAdapter by lazy {
        AdapterFragment(supportFragmentManager, mListFragment, mListTitle)
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_canvas
    }

    override fun initTitle(): String {
        return "Canvas"
    }

    override fun initData() {
        super.initData()
        mListTitle.addAll(resources.getStringArray(R.array.arrayCanvasColumn))

        mListTitle.forEachIndexed { index, _ ->
            when (index) {
                0 -> mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_circle))
                1 -> mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_arc))
                2 -> mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_line))
                3 ->  mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_oval))
                else -> mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_circle))
            }
        }
    }

    override fun initView() {
        super.initView()

        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        viewPager.adapter = mAdapter

        tabLayout.setupWithViewPager(viewPager)
    }

}
