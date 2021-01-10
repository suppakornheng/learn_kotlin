package com.developerthai.ch17recyclerviewsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rcv = findViewById<RecyclerView>(R.id.recyclerView)
        rcv.layoutManager = LinearLayoutManager(this)

        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rcv.addItemDecoration(itemDecor)

        val sqlite = SQLiteHelper.getInstance(this)
        val db = sqlite.writableDatabase
        val sql = "SELECT * FROM emergency_call"
        val cursor = db.rawQuery(sql, null)
        val adapter = Adapter(cursor)
        rcv.adapter = adapter
    }
}

