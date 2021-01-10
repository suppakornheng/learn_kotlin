package com.developerthai.ch17recyclerviewbasic

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtName = itemView.findViewById<TextView>(R.id.textView_name)
    var txtPhone = itemView.findViewById<TextView>(R.id.textView_phone)
}