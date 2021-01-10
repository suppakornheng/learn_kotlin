package com.developerthai.ch19flashlight

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.hardware.camera2.CameraManager
import android.content.pm.PackageManager
import android.widget.Switch
import android.widget.Toast

/*** สำหรับ Android M ขึ้นไปเท่านั้น ***/

class MainActivity : AppCompatActivity() {
    private lateinit var mCameraManager: CameraManager
    private lateinit var mCameraId: String
    private lateinit var mSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isFlashAvailable =
            applicationContext.packageManager.hasSystemFeature(
                PackageManager.FEATURE_CAMERA_FLASH)

        if (!isFlashAvailable) {
            Toast.makeText(baseContext, "Flash not available" , Toast.LENGTH_LONG).show()
        }

        mCameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        mCameraId = mCameraManager.cameraIdList[0]

        mSwitch = findViewById(R.id.switch1)
        mSwitch.setOnCheckedChangeListener { _, isChecked ->
            mCameraManager.setTorchMode(mCameraId, isChecked)
        }
    }

}
