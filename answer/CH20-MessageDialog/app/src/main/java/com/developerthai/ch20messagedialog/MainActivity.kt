package com.developerthai.ch20messagedialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                showMessageDialog()
            }
        }
    }

    private fun showMessageDialog() {
        AlertDialog.Builder(this@MainActivity).apply {
            setTitle("ข้อผิดพลาด")
            setMessage("ไม่สามารถเชื่อมต่ออินเทอร์เน็ตได้ \nจะทดลองใหม่หรือไม่?")
            setPositiveButton("ตกลง") { _, _ ->
                Toast.makeText(baseContext, "กำลังเริ่มการเชื่อมต่อใหม่...", Toast.LENGTH_SHORT)
                    .show()
            }
            setNegativeButton("ยกเลิก") { _, _ ->
                Toast.makeText(baseContext, "ยกเลิก", Toast.LENGTH_SHORT).show()
            }
            show()
        }
    }
}
