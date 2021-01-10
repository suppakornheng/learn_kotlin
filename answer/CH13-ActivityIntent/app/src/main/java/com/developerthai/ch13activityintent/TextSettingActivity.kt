package com.developerthai.ch13activityintent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class TextSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_setting)

        showToast("Text Create")
        val size = intent.getIntExtra("size", 14)
        val color = intent.getStringExtra("color")
        val styles = intent.getStringArrayListExtra("styles")

        val editSize = findViewById<EditText>(R.id.editText_size)
        editSize.setText("$size")

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup_color)
        when (color.toLowerCase()) {
            "red" -> radioGroup.check(R.id.radio_red)
            "green" -> radioGroup.check(R.id.radio_green)
            "blue" -> radioGroup.check(R.id.radio_blue)
        }

        val checkBold = findViewById<CheckBox>(R.id.check_bold)
        val checkItalic = findViewById<CheckBox>(R.id.check_italic)
        if (styles.contains("bold")) {
            checkBold.isChecked = true
        }
        if (styles.contains("italic")) {
            checkItalic.isChecked = true
        }

        findViewById<Button>(R.id.button_ok).apply {
            setOnClickListener {
                if (editSize.text.isEmpty()) {
                    editSize.setText("$size")
                }

                val sz: Int = editSize.text.toString().toInt()
                if (sz !in 14..40) {
                    toast("ขนาดต้องอยู่ระหว่าง 14 - 40")
                    return@setOnClickListener
                }

                val co = when (radioGroup.checkedRadioButtonId) {
                    R.id.radio_red -> "red"
                    R.id.radio_green -> "green"
                    R.id.radio_blue -> "blue"
                    else -> color
                }

                val st = arrayListOf<String>()
                if (checkBold.isChecked) {
                    st.add("bold")
                }
                if (checkItalic.isChecked) {
                    st.add("italic")
                }
                intent.apply {
                   putExtra("size", sz)
                   putExtra("color", co)
                  putStringArrayListExtra("styles", st)
                }
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

    }
    override fun onStart() {
        super.onStart()
        showToast("Text Start")
    }

    override fun onResume() {
        super.onResume()
        showToast("Text Resume")
    }

    override fun onPause() {
        super.onPause()
        showToast("Text Pause")
    }

    override fun onStop() {
        super.onStop()
        showToast("Text Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("Text Destroy")
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg,
            Toast.LENGTH_SHORT).show()
    }
    private fun toast(msg: String) {
        Toast.makeText(baseContext, msg, Toast.LENGTH_LONG).show()
    }
}
