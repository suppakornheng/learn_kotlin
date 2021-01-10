package com.developerthai.ch19video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import android.R.attr.start
import android.R.attr.path
import android.widget.MediaController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val video = findViewById<VideoView>(R.id.videoView)
        val path = "android.resource://$packageName/${R.raw.big_buck_bunny}"

        video.setVideoPath(path)
        val controller = MediaController(this)
        video.setMediaController(controller)
        controller.show()
        video.start()
    }
}
