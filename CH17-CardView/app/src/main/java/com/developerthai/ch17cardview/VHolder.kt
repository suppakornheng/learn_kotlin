package com.developerthai.ch17cardview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imgView = itemView.findViewById<ImageView>(R.id.imageView)
    var txtTitle = itemView.findViewById<TextView>(R.id.textView_title)
    var txtDetail = itemView.findViewById<TextView>(R.id.textView_detail)
}
