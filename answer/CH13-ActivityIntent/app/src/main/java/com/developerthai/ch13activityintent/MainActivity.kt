package com.developerthai.ch13activityintent

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val REQ_CODE = 5555

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showToast("Main Create")
        findViewById<Button>(R.id.button_set_font).apply {
            setOnClickListener {
                val intent = Intent(this@MainActivity, TextSettingActivity::class.java)
                intent.apply {      //แนบค่าดีฟอลต์ปยังแอกทิวิตี้ปลายทาง
                    putExtra("size", 14)
                    putExtra("color", "green")
                    putStringArrayListExtra("styles", arrayListOf("normal"))
                }
                startActivityForResult(intent, REQ_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        showToast("Main onActivityResult")
        if (requestCode != REQ_CODE || resultCode != Activity.RESULT_OK) {
            return
        }
        val size = data?.getIntExtra("size", 14)
        val color = data?.getStringExtra("color")
        //เปลี่ยนสีจากสตริงเป็นค่าแบบ hex
        //แม้จะมีเมธอด parse() อยู่แล้ว แต่อาจได้เฉดสีที่ไม่ตรงตามต้องการ
        val col = when (color) {
            "red" -> "#990000"
            "green" -> "#009900"
            "blue" -> "#000099"
            else -> "#009900"
        }
        val styles = data?.getStringArrayListExtra("styles")
        var typeFace = Typeface.NORMAL
        //เทียบจากสตริง เป็นค่าคงที่ของ Typeface
        if (styles!!.contains("bold")) {
            typeFace = typeFace or Typeface.BOLD
        }
        if (styles!!.contains("italic")) {
            typeFace = typeFace or Typeface.ITALIC
        }
        //กำหนดรูปแบบให้แก่ TextView
        val sampleText = findViewById<TextView>(R.id.textView_sample)
        sampleText.apply {
            textSize = size!!.toFloat()
            setTextColor(Color.parseColor(col))
            setTypeface(null, typeFace)
        }
    }
    override fun onStart() {
        super.onStart()
        showToast("Main Start")
    }

    override fun onResume() {
        super.onResume()
        showToast("Main Resume")
    }

    override fun onPause() {
        super.onPause()
        showToast("Main Pause")
    }

    override fun onStop() {
        super.onStop()
        showToast("Main Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("Main Destroy")
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg,
            Toast.LENGTH_SHORT).show()
    }
}
