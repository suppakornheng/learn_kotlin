package com.developerthai.ch12toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                val toast = Toast.makeText(this@MainActivity, 123, Toast.LENGTH_LONG)
                toast.setGravity(Gravity.LEFT or Gravity.TOP, 50, 250)
                toast.show()
            }
        }


    }
}
