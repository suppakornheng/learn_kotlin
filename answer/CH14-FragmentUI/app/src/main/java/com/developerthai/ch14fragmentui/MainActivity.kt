package com.developerthai.ch14fragmentui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_login).apply {
            setOnClickListener {
                showFragment(LoginFragment())
            }
        }

        findViewById<Button>(R.id.button_info).apply {
            setOnClickListener {
                showFragment(InfoFragment())
            }
        }
    }

    private fun showFragment(fm: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fm)
            .commit()
    }
}
