package com.developerthai.ch20datepickerdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.app.DatePickerDialog
import android.widget.Button
import java.util.*
import android.widget.Toast

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
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val listener =  DatePickerDialog.OnDateSetListener { view, year, month, day ->
            //เมื่อคลิกปุ่ม OK บนไดอะล็อก ให้อ่านค่า year/month/day ไปใช้งาน
            val str = "${day.toString()} - ${month + 1} - $year"
            Toast.makeText(baseContext, str, Toast.LENGTH_LONG).show()
        }
        val dialog = DatePickerDialog(this@MainActivity, listener, year, month, day)
        dialog.show()
    }

    private fun onDatePickerDialogSet(year: Int, month: Int, day: Int) {

    }

}
