package com.suppakorn.ch17_demo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VHolder(v: View): RecyclerView.ViewHolder(v){
    var textTitle = v.findViewById<TextView>(R.id.textView_title)
    var textValue = v.findViewById<TextView>(R.id.textView_value)
}