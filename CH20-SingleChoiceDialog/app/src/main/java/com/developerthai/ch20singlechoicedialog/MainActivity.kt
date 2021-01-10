package com.developerthai.ch20singlechoicedialog

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
        var checkedIndex = 0

        AlertDialog.Builder(this@MainActivity).apply {
            setIcon(R.mipmap.ic_launcher)
            setTitle("เลือกเวอร์ชันของแอนดรอยด์")
            setSingleChoiceItems(items, checkedIndex) { _, which ->
                //อ่านรายการที่ถูกคลิกเก็บพักไว้ในอาร์เรย์ เมื่อเราเปลี่ยนไปเลือกรายการอื่น
                //ค่าที่เก็บในอาร์เรย์ ก็จะถูกแทนที่ด้วยค่าใหม่ไปเรื่อยๆ
                checkedIndex = which
            }
            setPositiveButton("OK") { _, _ ->
                //นำค่าของรายการที่ถูกคลิกล่าสุดจากอาร์เรย์ไปใช้งาน
                Toast.makeText(baseContext, items[checkedIndex], Toast.LENGTH_SHORT).show()
            }
            show()
        }
    }

}
