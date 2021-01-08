package com.developerthai.todolist

import android.app.DatePickerDialog
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mSqliteHelper: SQLiteHelper
    private lateinit var mSqliteDB: SQLiteDatabase
    private lateinit var mRCV: RecyclerView

    private lateinit var toDoDate: Triple<Int?, Int?, Int?>
    private var toDoTitle: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       mSqliteHelper = SQLiteHelper.getInstance(this)
       mSqliteDB = mSqliteHelper.writableDatabase

        mRCV = findViewById(R.id.recyclerView)
        mRCV.layoutManager = LinearLayoutManager(this)
        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        mRCV.addItemDecoration(itemDecor)

        readDatabaseToRecyclerView()

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton).apply {
            setOnClickListener {
                showDatePickerDialog()
            }
        }

    }

    //เมธอดนี้ ห้ามเป็น private เพราะต้องเรียกใช้งานจากคลาส Adapter
    fun readDatabaseToRecyclerView() {
        val sql = "SELECT * FROM todo ORDER BY timestamp DESC"
        val cursor = mSqliteDB.rawQuery(sql, null)
        val adapter = Adapter(cursor)
        mRCV.adapter = adapter
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        toDoDate = Triple(null, null, null)
        val listener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            toDoDate = Triple(day, month + 1, year)
            showCustomInputDialog("")
        }

        val dialog = DatePickerDialog(this@MainActivity, listener, year, month, day)
        dialog.show()
    }

    private fun showCustomInputDialog(message: String) {
        val view = layoutInflater.inflate(R.layout.dialog_content, null)
        val edit = view.findViewById<EditText>(R.id.editText_custom_dialog)
        edit.setHint(message)
        AlertDialog.Builder(this@MainActivity).apply {
            setTitle("สิ่งที่ต้องทำ")
            setView(view)      //กำหนด Custom Layout ให้แก่ไดอะล็อก
            setPositiveButton("ตกลง", { dialog, which ->
                var str = edit.text.toString()
                toDoTitle = if (!str.trim().isNullOrBlank()) edit.text.toString() else null
                if (toDoDate.first != null && toDoTitle != null) {
                    insertDatabase()
                }
            })
            setNegativeButton("ยกเลิก", { dialog, which ->
                toDoTitle = null
            })
        }.show()
    }

    private fun insertDatabase() {
        //แปลงข้อมูลวันเดือนปีที่อ่านได้จาก DatePicker ให้เป็น Timestamp
        val dateStr = "${toDoDate.first}/${toDoDate.second}/${toDoDate.third}"
        val date = SimpleDateFormat("dd/MM/yyyy").parse(dateStr)
        val timeMillis = date.time

        var sql = """INSERT INTO todo (_id, title, timestamp) VALUES (?, ?, ?)"""
        var args = arrayOf(null, toDoTitle, timeMillis)
        mSqliteDB.execSQL(sql, args)

        readDatabaseToRecyclerView()
    }

    private fun toast(msg: String?) {
        val m = msg ?: "null"
        Toast.makeText(baseContext, m, Toast.LENGTH_LONG).show()
    }
}
