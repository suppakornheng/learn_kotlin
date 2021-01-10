package com.developerthai.ch19ringtone

import android.media.MediaPlayer
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textTitle = itemView.findViewById<TextView>(R.id.textView)
}
