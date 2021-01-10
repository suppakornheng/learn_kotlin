package com.suppakorn.ch12_demo

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var mEditPrice: EditText
    private lateinit var  mEditDown: EditText
    private lateinit var  mRadioGroup: RadioGroup
    private lateinit var  mEditRate: EditText
    private lateinit var  mSpinner: Spinner
    private lateinit var  mTextResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_main3)

        mEditPrice = findViewById(R.id.editText_price)
        mEditDown = findViewById(R.id.editText_down)
        mEditRate = findViewById(R.id.editText_rate)
        mRadioGroup = findViewById(R.id.radioGroup)
        mRadioGroup.check(R.id.radio_percent)
        //สร้างรายการของ Spinner ระหว่าง 1-6 ปี
        mSpinner = findViewById<Spinner>(R.id.spinner)
        val items = MutableList(6){"${it+1} ปี"}
        items.add(0,"ระยะเวลาการส่งงวด")
        val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_dropdown_item, items)
        mSpinner.adapter = adapter

        findViewById<Button>(R.id.button).apply{
            setOnClickListener{
                calculate()
            }
        }

        mTextResult = findViewById(R.id.textView_result)


//        val tos = Toast.makeText(baseContext,"Hello", Toast.LENGTH_LONG).show()
//        findViewById<Button>(R.id.button).apply{
//            setOnClickListener{
//                val snack = Snackbar.make(it , "Hello from Snackbar", Snackbar.LENGTH_LONG)
//                val text = snack.getView().findViewById<View>(R.id.snackbar_text)
//                val tv = text as TextView
//                tv.setTextColor(Color.YELLOW)
//                tv.textSize = 24F
//                snack.setAction("Cancel",View.OnClickListener {
//
//                })
//                snack.setActionTextColor(Color.CYAN)
//                val action = snack.getView().findViewById<View>(R.id.snackbar_action)
//                val act = action as TextView
//                act.textSize = 24F
//                snack.show()
//                snack.addCallback(object: Snackbar.Callback(){
//                    override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
//                        super.onDismissed(transientBottomBar, event)
//                        //
//                    }
//                    override fun onShown(sb: Snackbar?) {
//                        super.onShown(sb)
//                        //
//                    }
//                })
//            }
//        }
    }

    private fun calculate() {
        val price = mEditPrice.text.trim().toString().toInt()
        if(price<=0){
            toast("ราคาไม่ถูกต้อง")
            return
        }
        var down = mEditDown.text.trim().toString().toInt()
        if(mRadioGroup.checkedRadioButtonId == R.id.radio_percent){
            down = price *down/100
        }
        if(down<=0||down>price){
            toast("เงินดาวน์ไม่ถูกต้อง {$down}")
            return
        }

        //แปลงอัตราดอกเบี้ยให้เป็นแบบต่อเดือน
        var rate = mEditRate.text.trim().toString().toDouble()
        rate/=100
        rate/=12
        if(rate<=0){
            toast("อัตราดอกเบี้ยไม่ถูกต้อง")
            return
        }

        //ยอดจัดไฟแนนซ์
        val finance = price-down

        //ที่ Spinner เรากำหนดตัวเลือดเป็นจำนวนปี
        //ต้องแปลงเป็ฯจำนวนเดือน และเนื่องจากเลขลำดับของรายการ
        //ตรงกับเลขจำนวนปีพอดี เราจึงอ่านค่าจากเลขลำดับของรายการมาใช้แทนจำนวนปีได้เลย
        //ยกเว้นรายการแรกที่ใช้แสดงเป็นข้อความ
        if(mSpinner.selectedItemPosition==0){
            toast("กรุณาเลือกระยะเวลาการส่งงวด")
            return
        }
        val months = mSpinner.selectedItemPosition*12

        //อัตราดอกเบี้ยรวม
        val interest = finance* months.toDouble()*rate

        //ยอดจัดไฟแนนซ์รวมอัตราดอกเบี้ย คือยอดรวมที่ต้องผ่อนชำระ
        val total = finance + interest

        //ค่างวดต่อเดือน
        val installment = total/months

        //จัดรูปแบบตัวเลขให้อ่านง่ายขึ้น
        val format = NumberFormat.getNumberInstance()
        format.maximumFractionDigits = 2
        val result = format.format(installment)
        //แสดงผล
        mTextResult.text="ค่าส่งงวดเดือนละ $result บาท"
        //ซ่อนคีย์บอร์ด
        mEditPrice.onEditorAction(EditorInfo.IME_ACTION_DONE)
    }

    private fun toast(msg: String) {
        val t = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        t.setGravity(Gravity.TOP or Gravity.CENTER, 0,200)
//        t.view!!.background!!.colorFilter = PorterDuffColorFilter(Color.BLACK,PorterDuff.Mode.SRC_IN)
//        t.view!!.findViewById<TextView>(android.R.id.message)!!.setTextColor(Color.WHITE)
        t.show()

    }
}