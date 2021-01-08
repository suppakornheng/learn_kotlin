package com.developerthai.ch17recyclerviewbasic

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

        val items = mutableListOf<Item>()
        var i = Item("สมชาย พายเรือ", "099123xxxx")
        items.add(i)
        i =  Item("สมหญิง ยิงเรือ", "088456xxxx")
        items.add(i)
        items.add(Item("สมศรี มีเรือ", "099789xxxx"))
        items.add(Item("สมศักดิ์ รักเรือ", "088111xxxx"))
        items.add(Item("สมพงษ์ ลงเรือ", "099222xxxx"))
        val adapter = Adapter(items)
        rcv.adapter = adapter
    }
}
