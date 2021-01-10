package com.developerthai.ch17recyclerviewbasic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val data: List<Item>) : RecyclerView.Adapter<VHolder>() {

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val holder = VHolder(v)
        return holder
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.txtName.text = data[position].name
        holder.txtPhone.text = data[position].phone
    }

}