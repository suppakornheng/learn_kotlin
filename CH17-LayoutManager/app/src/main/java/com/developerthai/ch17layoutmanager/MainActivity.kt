package com.developerthai.ch17layoutmanager


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<Item>()
        items.add(Item(R.drawable.android, "Pixel", 2000))
        items.add(Item(R.drawable.android, "Samsung", 2500))
        items.add(Item(R.drawable.android, "Vivo", 1000))
        items.add(Item(R.drawable.android, "Oppo", 1500))
        items.add(Item(R.drawable.android, "Sony", 2000))
        items.add(Item(R.drawable.android, "Asus", 1000))
        items.add(Item(R.drawable.android, "Nokia", 500))

        val adapter = Adapter(items)

        val rcv = findViewById<RecyclerView>(R.id.recyclerView)
        //rcv.layoutManager = LinearLayoutManager(this)

       val grid = GridLayoutManager(this, 2)
                        //StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
                        //LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        rcv.layoutManager = grid
        rcv.adapter = adapter
    }
}

