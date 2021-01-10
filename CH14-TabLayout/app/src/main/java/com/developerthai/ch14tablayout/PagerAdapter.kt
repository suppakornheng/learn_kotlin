package com.developerthai.ch14tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
      override fun getCount() = 3

      override fun getItem(position: Int): Fragment? {
            return when (position) {
                  0 -> Tab1Fragment()
                  1 -> Tab2Fragment()
                  2 -> Tab3Fragment()
                  else -> null
            }
      }

      override fun getPageTitle(position: Int): CharSequence? {
            val pageTitles = arrayOf("Tab1", "Tab2", "Tab3")
            return pageTitles[position]
      }

}
