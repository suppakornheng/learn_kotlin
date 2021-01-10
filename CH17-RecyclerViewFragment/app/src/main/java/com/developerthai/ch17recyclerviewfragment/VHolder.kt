package com.developerthai.ch17recyclerviewfragment

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtProduct = itemView.findViewById<TextView>(R.id.textView_product)
    var txtPrice = itemView.findViewById<TextView>(R.id.textView_price)
}
