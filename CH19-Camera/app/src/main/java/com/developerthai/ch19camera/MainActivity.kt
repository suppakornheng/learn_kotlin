package com.developerthai.ch19camera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.provider.MediaStore
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_image).apply {
            setOnClickListener {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)
            }
        }

        findViewById<Button>(R.id.button_video).apply {
            setOnClickListener {
                val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
                startActivity(intent)
            }
        }
    }
}
