package com.developerthai.thaitorch

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import android.graphics.drawable.AnimationDrawable
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

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

        setFullScreen()
        animateBackground()

        mFlashAvailable = applicationContext.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)

        mCameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        mCameraId = mCameraManager.cameraIdList[0]

        mTorchImage = findViewById<ImageView>(R.id.imageView_torch).apply {
            setOnClickListener {
                setTorchImage()
            }
        }

        val mFirst = savedInstanceState?.getBoolean("mFirst") ?: true
        if (mFirst) {
            showAbout()
        }
    }

    private fun setTorchMode(mode: Boolean) {
        if (!mFlashAvailable) {
            return
        }
        mCameraManager.setTorchMode(mCameraId, mode)
    }

    private fun setTorchImage() {
        if (!mFlashAvailable) {
            alertNoFlash()
            return
        }

        if (!mIsOn) {
            mTorchImage.setImageResource(R.drawable.torchlight_on)
            setTorchMode(true)
        } else {
            mTorchImage.setImageResource(R.drawable.torchlight_off)
            setTorchMode(false)
        }

        mIsOn = !mIsOn
    }

    override fun onPause() {
        super.onPause()
        setTorchMode(false)
    }

    override fun onResume() {
        super.onResume()
        setTorchMode(mIsOn)
    }

    override fun onStop() {
        super.onStop()
        setTorchMode(false)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setTorchMode(false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putBoolean("mIsOn", mIsOn)
        outState.putBoolean("mFirst", false)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        //mIsOn = !savedInstanceState.getBoolean("mIsOn")
        //setTorchImage()
    }

    private fun alertNoFlash() {
        AlertDialog.Builder(this@MainActivity).apply {
            setMessage("อุปกรณ์นี้ไม่รองรับการใช้แฟลช")
            setNegativeButton("ตกลง", { _, _ ->
            }).show()
        }
    }

    private fun setFullScreen() {
        //ซ่อน ActionBar/TitleBar
        supportActionBar?.hide()

        //ทำให้แถบ StatusBar ถูกซ่อน
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //ซ่อนส่วนอื่นๆ ยกเว้น Navigation
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
    }

    private fun animateBackground() {
        val layout = findViewById<ConstraintLayout>(R.id.main_container)
        val animationDrawable =  layout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(4000)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()
    }

    private fun showAbout() {
        Toast.makeText(baseContext, "ThaiTorch\nพัฒนาโดย: บัญชา  ปะสีละเตสัง", Toast.LENGTH_SHORT).show()
    }
}

