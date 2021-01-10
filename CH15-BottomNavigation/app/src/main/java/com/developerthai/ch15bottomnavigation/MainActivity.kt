package com.developerthai.ch15bottomnavigation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener {
            return@setOnNavigationItemSelectedListener  when (it.itemId) {
                R.id.nav_home -> {
                    showFragment(HomeFragment())
                    true
                }
                R.id.nav_cart -> {
                    showFragment(ShoppingFragment())
                    true
                }
                R.id.nav_search -> {
                    showFragment(SearchFragment())
                    true
                }
                else -> false
            }
        }

        navView.selectedItemId = R.id.nav_home
        //ให้ปุ่มแรกถูกเลือก เพื่อให้เกิดอีเวนต์ ItemSelected
    }

    private fun showFragment(frag: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, frag)
            commit()
        }
    }
}

