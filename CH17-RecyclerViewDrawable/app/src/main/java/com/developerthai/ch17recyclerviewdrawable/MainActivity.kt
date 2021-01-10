package com.developerthai.ch17recyclerviewdrawable

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
        items.add(Item("Andy Rubin", "andy@example.com"))
        items.add(Item("สมหญิง ยิงเรือ", "ying@test.com"))
        items.add(Item("มานี มีนา", "manee@meena.com"))
        items.add(Item("James Gosling", "james@javax.com"))
        items.add(Item("Kate Kotlin", "kate@kotlin.org"))
        val adapter = Adapter(items)
        rcv.adapter = adapter
    }
}

