package com.developerthai.ch12carinstallment

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Range
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var mEditPrice: EditText
    private lateinit var mEditDown: EditText
    private lateinit var mRadioGroup: RadioGroup
    private lateinit var mEditRate: EditText
    private lateinit var mSpinner: Spinner
    private lateinit var mTextResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditPrice = findViewById(R.id.editText_price)
        mEditDown = findViewById(R.id.editText_down)
        mEditRate = findViewById(R.id.editText_rate)
        mRadioGroup = findViewById(R.id.radioGroup)
        mRadioGroup.check(R.id.radio_percent)

        mSpinner = findViewById<Spinner>(R.id.spinner)
        val items = MutableList(6) { "${it + 1} ปี" }     //1 - 6
        items.add(0, "ระยะเวลาการส่งงวด")
        val adapter =
            ArrayAdapter(baseContext, android.R.layout.simple_spinner_dropdown_item, items)
        mSpinner.adapter = adapter    //กำหนดเป็นรายการของ Spinner

        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                calculate()
            }
        }
        mTextResult = findViewById(R.id.textView_result)
    }

    private fun calculate() {
        val price = mEditPrice.text.trim().toString().toInt()
        if (price <= 0) {
            toast("ราคารถไม่ถูกต้อง")
            return
        }
        var down = mEditDown.text.trim().toString().toDouble()
        if (radioGroup.checkedRadioButtonId == R.id.radio_percent) {
            down = price * (down / 100)
        }

        if (down <= 0 || down > price) {
            toast("เงินดาวน์ไม่ถูกต้อง ($down)")
            return
        }

        //แปลงอัตราดอกเบี้ยให้เป็นแบบต่อเดือน
        var rate = mEditRate.text.trim().toString().toDouble()
        rate /= 100
        rate /= 12

        if (rate <= 0) {
            toast("อัตราดอกเบี้ยไม่ถูกต้อง")
            return
        }

        //ยอดจัดไฟแนนซ์
        val finance = price - down

        //ที่ Spinner เรากำหนดตัวเลือกเป็นจำนวนปี
        //ต้องแปลงเป็นจำนวนเดือน และเนื่องจากเลขลำดับของรายการ
        //ตรงกับเลขจำนวนปีพอดี เราจึงอ่านค่าจากเลขลำดับของรายการมาใช้แทนจำนวนปีได้เลย
        if (mSpinner.selectedItemPosition == 0) {   //รายการแรกใช้แสดงข้อความ
            toast("กรุณาเลือกระยะเวลาการส่งงวด")
            return
        }
        val months = mSpinner.selectedItemPosition * 12

        //อัตราดอกเบี้ยรวม
        val interest = finance * months.toDouble() * rate

        //ยอดจัดไฟแนนซ์รวมอัตราดอกเบี้ย คือยอดรวมที่ต้องผ่อนชำระ
        val total = finance + interest

        //ค่างวดต่อเดือน
        val installment = total / months

        //จัดรูปแบบตัวเลข ให้อ่านง่ายขึ้น
        val format = NumberFormat.getNumberInstance()
        format.maximumFractionDigits = 2
        val result = format.format(installment)

        //แสดงผล
        mTextResult.text = "ส่งงวดเดือนละ $result บาท"

        //ซ่อนคีย์บอร์ด
        mEditPrice.onEditorAction(EditorInfo.IME_ACTION_DONE)
    }

    //เมธอดสำหรับแสดง Toast โดยให้อยู๋ด้านบนของหน้า และกำหนดพื้นหลังเป็นสีดำ
    private fun toast(msg: String) {
        val t = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        t.setGravity(Gravity.TOP or Gravity.CENTER, 0, 200)
        t.view.background.colorFilter = PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN)
        t.view.findViewById<TextView>(android.R.id.message).setTextColor(Color.WHITE)
        t.show()
    }
}
