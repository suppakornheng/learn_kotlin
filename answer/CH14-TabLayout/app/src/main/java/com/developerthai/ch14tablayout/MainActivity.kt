package com.developerthai.ch14tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = PagerAdapter(supportFragmentManager)

        findViewById<TabLayout>(R.id.tabLayout).apply {
            setupWithViewPager(viewPager)
            getTabAt(0)?.setIcon(R.drawable.star)
            getTabAt(1)?.setIcon(R.drawable.favorite)
            getTabAt(2)?.setIcon(R.drawable.settings)
        }
    }
}
