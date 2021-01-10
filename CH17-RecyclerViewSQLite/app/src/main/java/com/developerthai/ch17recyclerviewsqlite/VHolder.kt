package com.developerthai.ch17recyclerviewsqlite

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtName = itemView.findViewById<TextView>(R.id.textView_name)
    var txtPhone = itemView.findViewById<TextView>(R.id.textView_phone)

    init {
        itemView.setOnClickListener {
            val text = "กำลังโทรออก\n${txtName.text}\n${txtPhone.text}"
            Toast.makeText(itemView.context, text, Toast.LENGTH_LONG).show()
        }
    }
}
