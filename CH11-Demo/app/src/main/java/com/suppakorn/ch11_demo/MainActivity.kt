package com.suppakorn.ch11_demo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //    private var btnOK: Button? = null
//    private var txtData: TextView? = null
//    private lateinit var btnOK: Button
//    private lateinit var txtData: TextView
    private lateinit var mEditNum1: EditText
    private lateinit var mEditNum2: EditText
    private lateinit var mTextResult: TextView
    private lateinit var mTextOp: TextView

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditNum1 = findViewById(R.id.editTextNumber)
        mEditNum2 = findViewById(R.id.editTextNumber2)
        mTextResult = findViewById(R.id.textView3)
        mTextOp = findViewById(R.id.textView2)

        fun calculate(op: String) {
            mTextOp.text = op
            val n1 = mEditNum1.text.trim().toString()
            val n2 = mEditNum2.text.trim().toString()
            if (n1.isEmpty() || n2.isEmpty()) {
                mTextResult.text = ""
                return
            }
            val num1 = n1.toDouble()
            val num2 = n2.toDouble()
            var r = when (op) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                else -> num1 / num2
            }
            mTextResult.text = if (r % 1== 0.0) "${r.toInt()}" else "$r"
        }

        findViewById<Button>(R.id.button2).apply {
            setOnClickListener {
                calculate(this.text.toString())
            }
        }
        findViewById<Button>(R.id.button3).apply {
            setOnClickListener {
                calculate(this.text.toString())
            }
        }
        findViewById<Button>(R.id.button4) .apply {
            setOnClickListener {
                calculate(this.text.toString())
            }
        }
        findViewById<Button>(R.id.button5) .apply {
            setOnClickListener {
                calculate(this.text.toString())
            }
        }


//        btnOK = findViewById(R.id.btnOK)
//        txtData = findViewById(R.id.textView)
//
//        btnOK.setOnClickListener {
//            // it
//        }
//        btnOK.setOnLongClickListener{
//            // it
//            true
//        }
//        btnOK.setOnTouchListener { v, _ ->
//            // v
//            true
//        }
//
//        findViewById<Button>(R.id.btnOK).apply{
//            setOnClickListener{
//                //it
//            }
//        }
//
//        val tv = findViewById<TextView>(R.id.textView)
//        tv.apply{
//            if(text == "Start") "Stop" else "Start
//        }

//        val textName = findViewById<EditText>(R.id.edt_name)
//        val textAddress = findViewById<EditText>(R.id.edt_address)
//        val name = textName.getText() // or textName.text.toString()
//        textAddress.setText("...")
//        btnOK.setOnClickListener { v ->
//            //
//        }
//        btnOK.setOnLongClickListener { v ->
//            //
//            true
//        }

//        btnOK.setOnClickListener() { v: View ->
//            //
//        }
//        btnOK.setOnLongClickListener() { v: View ->
//            //
//            true
//        }

//        btnOK.setOnClickListener({ v: View ->
//            //
//        })
//        btnOK.setOnLongClickListener({ v: View ->
//            //
//            true
//        })

//        val clickListener = {v:Viesw ->
//            //
//        }
//        btnOK.setOnClickListener(clickListener)
//        val longClickListener = {v:View->
//            //
//        }
//        btnOK.setOnLongClickListener(longClickListener)

//        btnOK.setOnClickListener(object: View.OnClickListener{
//            override fun onClick(v: View?){
//                //
//            }
//        })

//         val btnOK = findViewById<Button>(R.id.btnOK)
//         btnOK.isAllCaps = false
//         btnOk.apply{
//             isAllCaps = true
//             text = "Hello"
//             performClick()
//         }
//        val textView = findViewById<TextView>(R.id.textView)
//        val text = textView.text
    }

//    private fun test() {
////        btnOK?.text = "Hello"
////        btnOK?.performClick()
////        val str = txtData!!.text
//        btnOK.text = "Hello"      // lateinit declaration no need nullable call
//        btnOK.performClick()     // lateinit declaration no need nullable call
//        val str = txtData.text      // lateinit declaration no need nullable call
//    }


}
