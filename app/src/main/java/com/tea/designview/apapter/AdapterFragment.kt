package com.tea.designview.apapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * @desc
 * @author Tiany
 * @date  2017/11/8 0008
 */
class AdapterFragment(fm: FragmentManager, val listFragment: List<out Fragment>, val listTitle: List<String>) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getCount(): Int {
        return listFragment?.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return listTitle[position]
    }
}