package com.developerthai.ch17recyclerviewevent

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val data: List<Item>) : RecyclerView.Adapter<VHolder>() {

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val holder = VHolder(v)
        holder.sw.setOnCheckedChangeListener { compoundButton, isChecked ->
            val c = if (isChecked) Color.BLUE else Color.GRAY
            holder.txtName.setTextColor(c)
        }
        return holder
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.imgView.setImageResource(data[position].imgId)
        holder.txtName.text = data[position].itemName
        holder.txtName.setTextColor(Color.GRAY)
    }

}
