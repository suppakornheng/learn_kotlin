package com.developerthai.ch17layoutmanager

import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imgView = itemView.findViewById<ImageView>(R.id.imageView)
    var txtName = itemView.findViewById<TextView>(R.id.textView_title)
    var txtPhone = itemView.findViewById<TextView>(R.id.textView_price)
}
