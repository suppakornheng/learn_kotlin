package com.developerthai.torchlight

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var mTorchImage: ImageView
    private lateinit var mCameraManager: CameraManager
    private lateinit var mCameraId: String
    private var mIsOn: Boolean = false
    private var mFlashAvailable: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ล็อกหน้าจอให้อยู่ในแนวตั้งตลอด
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //ป้องกันการเข้าสู่ Sleep Mode
       window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        //setTurnScreenOn(true)     //ถ้า API 27+ ใช้เมธอดนี้แทนได้

       mFlashAvailable = applicationContext.packageManager.hasSystemFeature(
                                                PackageManager.FEATURE_CAMERA_FLASH)

        mCameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        mCameraId = mCameraManager.cameraIdList[0]

        mTorchImage = findViewById<ImageView>(R.id.imageView_torch).apply {
           setOnClickListener {
               setTorchImage()
           }
        }
    }

    private fun setTorchImage() {
        if (!mFlashAvailable) {
            alertNoFlash()
            return
        }

        //สลับภาพให้ตรงกับสถานะ On/Off
        if (!mIsOn) {
            mTorchImage.setImageResource(R.drawable.torchlight_on)
            setTorchMode(true)
        } else {
            mTorchImage.setImageResource(R.drawable.torchlight_off)
            setTorchMode(false)
        }
        mIsOn = !mIsOn      //สลับค่าของตัวแปรที่ให้เก็บสถานะ On/Off
    }

    //เมธอดสำหรับการสั่งเปิด-ปิด ไฟฉาย (แฟลช)
    private fun setTorchMode(mode: Boolean) {
        if (!mFlashAvailable) {
            return
        }
        mCameraManager.setTorchMode(mCameraId, mode)
    }

    //ถ้าแอกทิวิตี้ไม่ปรากฏบนหน้าจอ ให้ปิดไฟฉาย
    override fun onPause() {
        super.onPause()
        setTorchMode(false)
    }

    override fun onStop() {
        super.onStop()
        setTorchMode(false)
    }

    //ถ้าแอกทิวิตี้กลับมาปรากฏบนหน้าจออีกครั้ง
    //ให้กำหนดสถานะการเปิด-ปิดต่อเนื่องกับตอนที่จะถูกซ่อน
    override fun onResume() {
        super.onResume()
        setTorchMode(mIsOn)
    }

    //ถ้าปิดแอป ให้ปิดไฟฉายด้วย
    override fun onDestroy() {
        super.onDestroy()
        setTorchMode(false)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setTorchMode(false)
    }

    /*
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("mIsOn", mIsOn)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mIsOn = !savedInstanceState.getBoolean("mIsOn")
        setTorchImage()
    }
    */

    private fun alertNoFlash() {
        AlertDialog.Builder(this@MainActivity).apply {
            setMessage("อุปกรณ์นี้ไม่รองรับการใช้แฟลช")
            setNegativeButton("ตกลง", { _, _ ->
            }).show()
        }
    }
}
