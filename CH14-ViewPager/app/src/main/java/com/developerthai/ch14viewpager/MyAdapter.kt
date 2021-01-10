package com.developerthai.ch14viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount() = 3     //ถ้ามี 3 เพจ

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> FragmentOne()
            1 -> FragmentTwo()
            2 -> FragmentThree()
            else -> null
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        val pageTitles = arrayOf("Page1", "Page2", "Page3")
        return pageTitles[position]
    }
}
