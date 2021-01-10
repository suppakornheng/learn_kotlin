package com.developerthai.ch12guessnumber

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var mEditNum: EditText
    private lateinit var mRadioGroup: RadioGroup
    private lateinit var mRadioToast: RadioButton
    private lateinit var mRadioSnackBar: RadioButton
    private lateinit var mButton: Button
    private var mGameOver = true    //สถานะที่บ่งชี้ว่าจบเกมหรือยัง
    private var mRandomNum = 0      //เลขสุ่มที่ใช้ในการทาย
    private val MAX_GUESS = 7           //ทายได้ไม่เกิน 7 ครั้ง
    private var mGuessCount = 0         //นับจำนวนครั้งที่ทายไปแล้วในแต่ละเกม
    private lateinit var mImm: InputMethodManager  //ซ่อน-แสดงคีย์บอร์ด

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditNum = findViewById(R.id.editText_number)
        mRadioGroup = findViewById(R.id.radioGroup)
        mRadioToast = findViewById(R.id.radio_toast)
        mRadioSnackBar = findViewById(R.id.radio_snackbar)
        mImm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        mButton = findViewById<Button>(R.id.button_ok).apply {
            //การคลิกปุ่ม จะมี 2 กรณีคือ คลิกเพื่อเริ่มเกมใหม่ และคลิกเพื่อตรวจสอบตัวเลข
            setOnClickListener {
                if (mGameOver) {
                    start()
                } else {
                    compare()
                }
            }
        }
        gameOver()      //เริ่มแรก ให้อยู่ในสถานะเดียวกับการจบเกม
    }

    //เมธอดสำหรับเซตค่าต่างๆ เมื่อเริ่มต้นเล่นเกมใหม่
    private fun start() {
        //สร้างเลขสุ่มที่มีค่าระหว่าง 1 -  100
        mRandomNum = Random.nextInt(1, 101)
        mGuessCount = 0
        mButton.text = "ตกลง"
        mEditNum.isEnabled = true
        mEditNum.requestFocus()
        //ให้แสดงคีย์บอร์ดโดยอัตโนมัติ เพื่อความรวดเร็วในการใส่ข้อมูล
        mImm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        mGameOver = false
    }

    //เมธอดสำหรับเซตค่าเมื่อจบเกม
    private fun gameOver() {
        mGameOver = true
        mButton.text = "เริ่มเกมใหม่"
        mEditNum.isEnabled = false
    }

    //เมธอดสำหรับการตรวจสอบเลขที่ใส่เข้ามากับเลขที่ให้ทาย
    private fun compare() {
        val strGuessNum = mEditNum.text.trim().toString()
        mEditNum.setText("")
        if (strGuessNum.isNullOrEmpty()) {
            return
        }

        var guessNum = strGuessNum.toInt()
        var isWin = false
        var msg = ""
        //เปรียบเทียบเลขที่ใส่เข้ามากับเลขที่สุ่มได้
        //ถ้าใส่ค่ามากกว่า ให้แจ้งว่าเลขนั้น น้อยกว่านี้
        //ถ้าใส่ค่าน้อยกว่า ให้แจ้งว่าเลขนั้น มากกว่านี้
        //ถ้าใส่ค่าเท่ากัน แสดงว่าทายถูกต้อง
        when  {
            guessNum > mRandomNum -> msg = "น้อยกว่านี้"
            guessNum < mRandomNum -> msg = "มากกว่านี้"
            else -> {
                msg = "ถูกต้อง\nคลิกที่ปุ่มเพื่อเริ่มเกมใหม่"
                isWin = true
            }
        }

        if (!isWin) {           //ถ้าทายผิด
            mGuessCount++
            //ถ้าทายครบจำนวนครั้งสูงสุดแล้ว แต่ยังไม่ชนะ ก็ให้ถือว่าจบเกม
            if (mGuessCount == MAX_GUESS) {
                msg += "\nคุณทายครบ $MAX_GUESS ครั้งแล้ว\nคลิกที่ปุ่มเพื่อเริ่มเกมใหม่"
                gameOver()
            }
            showMessage(msg)
        } else {                //ถ้าทายถูก
            showMessage(msg)
            gameOver()
        }
    }

    //เมธอดสำหรับตรวจสอบว่าจะแสดงข้อความด้วย Toast หรือ Snackbar
    private fun showMessage(msg: String) {
        when  (mRadioGroup.checkedRadioButtonId) {
            R.id.radio_toast -> toast(msg)
            R.id.radio_snackbar -> snackbar(msg)
            else -> toast(msg)
        }
    }

    //เมธอดแสดง Toast โดยระบุตำแหน่ง สีพื้นหลัง และสีข้อความ
    private fun toast(msg: String) {
       val t = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        t.setGravity(Gravity.TOP or Gravity.CENTER, 0, 200)
        t.view.background.colorFilter = PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN)
        t.view.findViewById<TextView>(android.R.id.message).setTextColor(Color.WHITE)
        t.show()
    }

    //เมธอดสำหรับแสดง Snackbar โดยเมื่อแสดง ให้ซ่อนคีย์บอร์ด (มิฉะนั้นจะมองไม่เห็น Snackbar)
    //และเมื่อ Snackbar ถูกซ่อน ให้แสดงคีย์บอร์ด (เพื่อความรวดเร็วในการใส่ข้อมูล)
    private fun snackbar(msg: String) {
        val snack = Snackbar.make(mButton, msg, Snackbar.LENGTH_LONG)
        snack.addCallback(object : Snackbar.Callback() {
            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                if (!mGameOver) {
                    mImm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
                }
            }
            override fun onShown(snb: Snackbar?) {
                mEditNum.requestFocus()
                mImm.hideSoftInputFromWindow(mEditNum.windowToken, 0)
            }
        })
        snack.show()
    }
}
