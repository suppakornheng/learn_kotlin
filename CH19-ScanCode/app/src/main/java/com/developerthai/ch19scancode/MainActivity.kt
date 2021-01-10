package com.developerthai.ch19scancode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {
    private val KEY1: String = "KEY1"
    private var mCode: String = "Result"
    private lateinit var mTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById(R.id.textView)

        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
               val ii = IntentIntegrator(this@MainActivity)
                //ii.setOrientationLocked(true)
                ii.initiateScan()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null && result.contents != null) {
            mTextView.text = result.contents
            mCode = result.contents
        } else {
            mTextView.text = ""
            mCode = ""
        }
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY1, mCode)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getString(KEY1) != null) {
            mCode = savedInstanceState.getString(KEY1)!!
            mTextView.text = mCode
        } else {
            mTextView.text = "Result"
        }
    }
}
