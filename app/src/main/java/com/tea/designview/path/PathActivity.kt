package com.tea.designview.path

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.tea.designview.R
import com.tea.designview.apapter.AdapterFragment
import com.tea.designview.base.PageFragment
import com.teaphy.arc.base.BaseSimpleActivity

import kotlinx.android.synthetic.main.activity_path.*

class PathActivity  : BaseSimpleActivity() {

    private val mListFragment = mutableListOf<Fragment>()
    private val mListTitle = mutableListOf<String>()
    private val mAdapter by lazy {
        AdapterFragment(supportFragmentManager, mListFragment, mListTitle)
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_path
    }

    override fun initTitle(): String {
        return "Path"
    }

    override fun initData() {
        super.initData()
        mListTitle.addAll(resources.getStringArray(R.array.arrayPathColumn))

        mListTitle.forEachIndexed { index, _ ->
            when (index) {
                0 -> mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_path_arc))
                1 -> mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_path_circle))
                2 -> mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_path_oval))
                3 ->  mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_path_rect))
                4 ->  mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_path_round_rect))
                5 ->  mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_path_arc_to))
                6 ->  mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_path_quad_to))
                7 ->  mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_path_cubic_to))
                8 ->  mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_path_line_to))
                9 ->  mListFragment.add(PageFragment.NEWINSTANCE(R.layout.layout_path_close))
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