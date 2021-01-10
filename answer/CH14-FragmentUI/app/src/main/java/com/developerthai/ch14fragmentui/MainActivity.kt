package com.developerthai.ch14fragmentui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showToast("Main Create")

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

    override fun onStart() {
        super.onStart()
        showToast("Main Start")
    }

    override fun onResume() {
        super.onResume()
        showToast("Main Resume")
    }

    override fun onPause() {
        super.onPause()
        showToast("Main Pause")
    }

    override fun onStop() {
        super.onStop()
        showToast("Main Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("Main Destroy")
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}