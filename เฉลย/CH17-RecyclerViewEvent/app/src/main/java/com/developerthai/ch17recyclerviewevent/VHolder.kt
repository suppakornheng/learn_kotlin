package com.developerthai.ch17recyclerviewevent

import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imgView = itemView.findViewById<ImageView>(R.id.imageView)
    var txtName = itemView.findViewById<TextView>(R.id.textView)
    var sw = itemView.findViewById<Switch>(R.id.switch1)

    init {
        itemView.setOnClickListener {
            val state = if (sw.isChecked) "On" else "Off"
            Toast.makeText(itemView.context,
                "${txtName.text} $state \nรายการลำดับที่ ${adapterPosition + 1}",
                Toast.LENGTH_SHORT).show()
        }
        /*
        sw.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                txtName.setTextColor(Color.BLUE)
            } else {
                txtName.setTextColor(Color.GRAY)
            }
        }
        */
    }
}
