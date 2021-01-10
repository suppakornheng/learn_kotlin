package com.developerthai.ch19cameraresult

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val uri = intent.getStringExtra("uri")
        val vdoView = findViewById<VideoView>(R.id.videoView)
        vdoView.setVideoURI(Uri.parse(uri))
        vdoView.start()
    }
}
