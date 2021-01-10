package com.developerthai.ch20timepickerdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TimePicker
import android.app.TimePickerDialog
import java.util.*


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
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val min = calendar.get(Calendar.MINUTE)
        val listener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
            val str = "$hour:$minute"
            Toast.makeText(baseContext, str, Toast.LENGTH_LONG).show()
        }

        val dialog = TimePickerDialog(this@MainActivity, listener, hour, min, true)
        //true คือแสดงเป็นเวลาแบบ 24 ชั่วโมง ถ้า false จะแสดงเป็นเวลาแบบ AM/PM

        dialog.show()
    }

}
