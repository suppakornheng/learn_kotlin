package com.developerthai.ch17cardview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val data: List<Item>) : RecyclerView.Adapter<VHolder>() {

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return VHolder(v)
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.apply {
            imgView.setImageResource(data[position].img)
            txtTitle.text = data[position].title
            txtDetail.text = data[position].detail
        }
    }

}
