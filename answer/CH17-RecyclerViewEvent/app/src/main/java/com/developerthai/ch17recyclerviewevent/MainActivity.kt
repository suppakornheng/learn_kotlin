package com.developerthai.ch17recyclerviewevent

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
        items.add(Item(R.drawable.cellular, "Cellular"))
        items.add(Item(R.drawable.wifi, "Wi-Fi"))
        items.add(Item(R.drawable.bluetooth, "Bluetooth"))
        items.add(Item(R.drawable.hotspot, "Hotspot"))
        items.add(Item(R.drawable.airplanemode, "Airplane Mode"))
        val adapter = Adapter(items)
        rcv.adapter = adapter
    }
}

