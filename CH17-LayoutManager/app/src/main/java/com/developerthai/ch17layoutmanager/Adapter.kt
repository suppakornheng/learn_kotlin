package com.developerthai.ch17layoutmanager

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat

class Adapter(val data: List<Item>) : RecyclerView.Adapter<VHolder>() {

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val holder = VHolder(v)
        return holder
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.apply {
            imgView.setImageResource(data[position].img)
            txtName.text = data[position].title
            var numFormat = NumberFormat.getInstance()
            var priceFormat = numFormat.format(data[position].price)
            txtPhone.text = "$priceFormat บาท"
        }
    }

}
