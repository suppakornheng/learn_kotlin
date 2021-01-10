package com.developerthai.ch19cameraresult

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val uri = intent.getStringExtra("uri")
        val imgView = findViewById<ImageView>(R.id.imageView2)

        imgView.setImageURI(Uri.parse(uri))
    }
}
