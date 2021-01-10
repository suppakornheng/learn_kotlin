package com.developerthai.ch15popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.imageView).apply {
            setOnClickListener {
                showPopupMenu(this)     //this หมายถึง Button
            }
        }
    }

    private fun showPopupMenu(v: View) {
        PopupMenu(baseContext, v).apply {
            inflate(R.menu.menu_popup)      //ระบุชื่อไฟล์ XML ใน Resource

            //กำหนดอีเวนต์ในแบบแลมบ์ดา (ต้องคืนค่าให้กับเมธอด setOnMenuItemClickListener)
            setOnMenuItemClickListener {
                return@setOnMenuItemClickListener when (it?.itemId) {
                    R.id.menu_edit, R.id.menu_share, R.id.menu_delete -> {
                        toast(it.title)
                        true
                    }
                    else -> true
                }
                true
            }
            show()
        }
    }

    private fun toast(msg: CharSequence) {
        Toast.makeText(baseContext, msg, Toast.LENGTH_LONG).show()
    }
}
