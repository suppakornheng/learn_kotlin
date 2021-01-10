package com.developerthai.ch19audio

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val data: List<Item>) : RecyclerView.Adapter<VHolder>() {
    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(
                                        R.layout.recycler_view_item,
                                        parent, false)

        val holder = VHolder(v)
        v.setOnClickListener {
            val pos = holder.adapterPosition
            val rt = data[pos].ringtone
            val mp = MediaPlayer.create(v.context,  rt)
            mp.start()
        }
        return holder
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.textTitle.text = data[position].title
    }
}
