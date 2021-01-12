package com.suppakorn.ch17_demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val data: List<item>): RecyclerView.Adapter<VHolder>(){
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val holder = VHolder(v)
        return holder
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.textTitle.text = data[position].title
        holder.textValue.text = data[position].value
    }

}