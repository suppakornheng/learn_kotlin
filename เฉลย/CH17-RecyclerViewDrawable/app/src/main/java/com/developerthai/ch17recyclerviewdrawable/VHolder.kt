package com.developerthai.ch17recyclerviewdrawable

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtDraw = itemView.findViewById<TextView>(R.id.textView_drawable)
    var txtName = itemView.findViewById<TextView>(R.id.textView_name)
    var txtEmail = itemView.findViewById<TextView>(R.id.textView_email)
}
