package com.developerthai.ch20multichoicedialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

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
        val items = arrayOf("Vivo", "Oppo", "Samsung", "Huawei", "Sony")
        val checkedItems = BooleanArray(items.size)
        checkedItems[2] = true;  //ให้สมาชิกลำดับที่ 2 ถูกเลือกไว้ล่วงหน้า (ลำดับที่ไม่กำหนดจะไม่ถูกเลือก)

        AlertDialog.Builder(this@MainActivity).apply {
            setTitle("Android Phone ที่ท่านสนใจ")
            setMultiChoiceItems(items, checkedItems) { _, which, isChecked ->
                //เปลี่ยนค่าในอาร์เรย์ ให้ตรงกับสถานะของการเลือก
                checkedItems[which] = isChecked
            }
            setPositiveButton("OK") { _, _ ->
                var str = ""
                var selectItems = mutableListOf<String>()
                var i = 0
                for (b in checkedItems) {
                    if  (b) {
                        selectItems.add(items[i])
                    }
                    i++
                }
                str = selectItems.joinToString(", ")
                Toast.makeText(baseContext, str, Toast.LENGTH_LONG).show()
            }
            show()
        }
    }

}
