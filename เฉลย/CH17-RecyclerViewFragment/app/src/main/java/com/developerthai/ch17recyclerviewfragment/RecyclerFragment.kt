package com.developerthai.ch17recyclerviewfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)

        val rcv = view.findViewById<RecyclerView>(R.id.recyclerView)
        rcv.layoutManager = LinearLayoutManager(view.context)
        val itemDecor = DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        rcv.addItemDecoration(itemDecor)

        val list = mutableListOf<Item>()
        list.add(Item("Samsung", 25000))
        list.add(Item("Oppo", 10000))
        list.add(Item("Vivo", 12300))
        list.add(Item("Asus", 8000))
        list.add(Item("Nokia", 9000))
        rcv.adapter = Adapter(list)
        return view
    }
}
