package com.developerthai.ch14viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = MyAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.viewPager)
        pager.adapter = pagerAdapter

        val dotsIndicator = findViewById<SpringDotsIndicator>(R.id.dotsIndicator)
        dotsIndicator.setViewPager(pager)

        pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
                override fun onPageSelected(position: Int) {
                    val str = "เพจ ${position + 1}"
                    Toast.makeText(baseContext, str, Toast.LENGTH_SHORT).show()
                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                }

                override fun onPageScrollStateChanged(state: Int) {

                }
            })

    }
}
