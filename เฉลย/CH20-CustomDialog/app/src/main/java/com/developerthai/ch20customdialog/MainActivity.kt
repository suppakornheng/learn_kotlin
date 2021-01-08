package com.developerthai.ch20customdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                showDialog("กำหนดข้อมูล")
            }
        }
    }

    private fun showDialog(message: String) {
        val view = layoutInflater.inflate(R.layout.dialog_content, null)
        val edit = view.findViewById<EditText>(R.id.editText)
        edit.hint = message
        AlertDialog.Builder(this@MainActivity).apply {
            setTitle("Input Dialog")
            setView(view)      //กำหนด Custom Layout ให้แก่ไดอะล็อก
            setPositiveButton("OK") { _, _ ->
                val str = edit.text.toString()
                onInputDialogReturnData(str)        //แยกการใช้ค่าจากไดอะล็อกไปไว้ในเมธอดต่างหาก
            }
            setNegativeButton("Cancel") { _, _ ->
                onInputDialogReturnData(null)
            }
            show()
        }
    }

    //นำค่าจากไดอะล็อกไปใช้งาน
    private fun onInputDialogReturnData(data: String?) {
        if (data != null) {
            Toast.makeText(getBaseContext(), data, Toast.LENGTH_SHORT).show()
        }
    }

}
