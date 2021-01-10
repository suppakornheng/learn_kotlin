package com.developerthai.ch14fragmenttransaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            findViewById<Button>(R.id.button_one).apply {
                  setOnClickListener {
                        showFragment(FragmentOne())
                  }
            }

            findViewById<Button>(R.id.button_two).apply {
                  setOnClickListener {
                        showFragment(FragmentTwo())
                  }
            }

            findViewById<Button>(R.id.button_three).apply {
                  setOnClickListener {
                        showFragment(FragmentThree())
                  }
            }

      }

      private fun showFragment(fm: Fragment) {
            supportFragmentManager.beginTransaction()
                  .replace(R.id.frameLayout, fm)
                  .commit()
      }
}
