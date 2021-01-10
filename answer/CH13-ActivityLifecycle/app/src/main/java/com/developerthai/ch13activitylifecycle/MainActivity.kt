package com.developerthai.ch13activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showToast("Create")
    }

    override fun onStart() {
        super.onStart()
        showToast("Start")
    }

    override fun onResume() {
        super.onResume()
        showToast("Resume")
    }

    override fun onPause() {
        super.onPause()
        showToast("Pause")
    }

    override fun onStop() {
        super.onStop()
        showToast("Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("Destroy")
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg,
            Toast.LENGTH_SHORT).show()
    }
}

