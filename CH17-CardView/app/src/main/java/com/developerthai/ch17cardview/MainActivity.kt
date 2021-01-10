package com.developerthai.ch17cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rcv = findViewById<RecyclerView>(R.id.recyclerView)
        rcv.layoutManager = LinearLayoutManager(this)

        val items = mutableListOf<Item>()
        items.add(Item(R.drawable.pi, "Pie", "The central theme among Android 9 Pie’s updates is the aid of artificial intelligence technology to help the OS..."))
        items.add(Item(R.drawable.oreo, "Oreo", "Android 8 Oreo's list of new feature enhancements and additions ranges from picture-in-picture app and video support..."))
        items.add(Item(R.drawable.nougat, "Nougat", "Android 7 Nougat adds key new features such as Split Screen for true multitasking, a Doze on the Go feature to conserve battery..."))
        items.add(Item(R.drawable.marshmallow, "Marshmallow", "Android Marshmallow refines the enhanced Material Design user interface that first debuted in Lollipop..."))

        val adapter = Adapter(items)
        rcv.adapter = adapter
    }
}

