package com.developerthai.ch19cameraresult

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.core.content.FileProvider
import java.io.File

class MainActivity : AppCompatActivity() {
    private val REQ_CODE_IMG = 123
    private val REQ_CODE_VDO = 456
    private lateinit var mFilePath: String
    private lateinit var mExternalDir: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mExternalDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!

        findViewById<Button>(R.id.button_image).apply {
            setOnClickListener {
                imageCapture()
            }
        }

        findViewById<Button>(R.id.button_video).apply {
            setOnClickListener {
                videoCapture()
            }
        }
    }

    private fun imageCapture() {
        val photoFile = File.createTempFile("IMG${System.currentTimeMillis()}", ".jpg", mExternalDir)
        mFilePath = photoFile.absolutePath
        val uri = FileProvider.getUriForFile(this, "com.developerthai.ch19cameraresult", photoFile)
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        startActivityForResult(intent, REQ_CODE_IMG)
    }

    private fun videoCapture() {
        val videoFile = File.createTempFile("VDO${System.currentTimeMillis()}", ".mp4", mExternalDir)
        mFilePath = videoFile.absolutePath
        val uri = FileProvider.getUriForFile(this, "com.developerthai.ch19cameraresult", videoFile)
        val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        startActivityForResult(intent, REQ_CODE_VDO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQ_CODE_IMG && resultCode == Activity.RESULT_OK) {
            val photoFile = File(mFilePath)
            val uri = Uri.fromFile(photoFile)
            val i = Intent(this@MainActivity, ImageActivity::class.java)
            i.putExtra("uri", uri.toString())
            startActivity(i)
        } else if (requestCode == REQ_CODE_VDO && resultCode == Activity.RESULT_OK) {
            val videoFile = File(mFilePath)
            val uri = Uri.fromFile(videoFile)
            val i = Intent(this@MainActivity, VideoActivity::class.java)
            i.putExtra("uri", uri.toString())
            startActivity(i)
        }

    }

}
