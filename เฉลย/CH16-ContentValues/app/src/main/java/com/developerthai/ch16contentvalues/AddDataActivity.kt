package com.developerthai.ch16contentvalues

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddDataActivity : AppCompatActivity() {
    private lateinit var mEdtOrgName: EditText
    private lateinit  var mEdtPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        mEdtOrgName = findViewById(R.id.edtText_org_name)
        mEdtPhone = findViewById(R.id.edtText_phone)
        btnOkClick()
        btnBackClick()
    }

    private fun btnOkClick() {
        findViewById<Button>(R.id.btn_ok).apply {
            setOnClickListener {
                val sqliteHelper = SQLiteHelper.getInstance(baseContext)
                val db = sqliteHelper.writableDatabase

                val cv = ContentValues()
                cv.put("name", mEdtOrgName.text.toString())
                cv.put("phone", mEdtPhone.text.toString())
                db.insert("emergency_call", null, cv)

                Toast.makeText(baseContext, "บันทึกข้อมูลแล้ว", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun btnBackClick() {
        findViewById<Button>(R.id.btn_back).apply {
            setOnClickListener {
                finish()
            }
        }
    }
}

