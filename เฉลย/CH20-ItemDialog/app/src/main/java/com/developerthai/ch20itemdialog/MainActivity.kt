package com.developerthai.ch20itemdialog

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
                showDialog()
            }
        }
    }

    private fun showDialog() {
        val items = arrayOf("Marshmallow", "Lollipop", "Nougat", "Oreo", "Pie", "Android 10")
        AlertDialog.Builder(this@MainActivity).apply {
            setIcon(R.mipmap.ic_launcher)
            setTitle("เลือกเวอร์ชันของแอนดรอยด์")
            setItems(items) { _, which ->
                Toast.makeText(baseContext, items[which], Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("Cancel") { _, _ ->
                Toast.makeText(baseContext, "ยกเลิก", Toast.LENGTH_SHORT).show()
            }
            show()
        }
    }
}
