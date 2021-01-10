package com.developerthai.ch18permissions

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val CAMERA = Manifest.permission.CAMERA
    private val READ_EXT = Manifest.permission.READ_EXTERNAL_STORAGE
    private val GRANTED = PackageManager.PERMISSION_GRANTED
    private val REQ_CODE_CAMERA = 555
    private val REQ_CODE_READ = 777

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_camera).apply {
            setOnClickListener {
                cameraPermission()
            }
        }

        findViewById<Button>(R.id.button_read_ext).apply {
            setOnClickListener {
                readExternalPermission()
            }
        }
    }

    private fun cameraPermission() {
        if (ContextCompat.checkSelfPermission(this, CAMERA) == GRANTED) {
            toast("$CAMERA \nได้รับอนุญาตแล้ว")
        } else {
            requestPermissions(arrayOf(CAMERA), REQ_CODE_CAMERA)
        }
    }

    private fun readExternalPermission() {
        if (ContextCompat.checkSelfPermission(this, READ_EXT) == GRANTED) {
            toast("$READ_EXT \nได้รับอนุญาตแล้ว")
        } else {
            requestPermissions(arrayOf(READ_EXT), REQ_CODE_READ)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //ผลลัพธ์ที่ส่งกลับมา ต้องตรวจสอบว่าตรงกับ Request Code ของปุ่มใด
        when (requestCode) {
            REQ_CODE_CAMERA -> {
                if (permissions.isNotEmpty() && grantResults[0] == GRANTED) {
                    toast("$CAMERA \nได้รับอนุญาตแล้ว")
                } else {
                    toast("การร้องขอ\n$CAMERA \nถูกปฏิเสธ")
                }
            }
            REQ_CODE_READ -> {
                if (permissions.isNotEmpty() && grantResults[0] == GRANTED) {
                    toast("$READ_EXT \nได้รับอนุญาตแล้ว")
                } else {
                    toast("การร้องขอ\n$READ_EXT \nถูกปฏิเสธ")
                }
            }
        }
    }

    private fun toast(msg: String) {
        Toast.makeText(baseContext, msg, Toast.LENGTH_LONG).show()
    }
}
