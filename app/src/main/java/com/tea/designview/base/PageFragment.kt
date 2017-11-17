package com.tea.designview.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @desc
 * @author Tiany
 * @date  2017/11/8 0008
 */
class PageFragment: Fragment() {

    companion object {

        const val KEY_LAYOUT = "KEY_LAYOUT"

        fun NEWINSTANCE(@LayoutRes resLayout: Int): PageFragment {
            val frm = PageFragment()
            val bundle = Bundle()
            bundle.putInt(KEY_LAYOUT, resLayout)
            frm.arguments = bundle
            return frm
        }
    }

    private var resLayout: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(resLayout, container, false)
    }

    private fun initData() {
        val bundle = arguments
        resLayout = bundle.getInt(KEY_LAYOUT)
    }
}