package com.suppakorn.ch17_demo


import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rcv = findViewById<RecyclerView>(R.id.recyclerview)
        rcv.layoutManager = LinearLayoutManager(this)

        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rcv.addItemDecoration(itemDecor)

        val items = mutableListOf<item>()
        var i = item("OS", "Adroid")
        items.add(i)
        i = item("Version", "15.0")
        items.add(i)
        items.add(item("Display", "6.0"))
        items.add(item("RAM", "8 GB"))
        items.add(item("Storage", "64 GB"))
        rcv.adapter = Adapter(items)
    }
}

