package com.developerthai.ch19ringtone

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val data: List<Item>) : RecyclerView.Adapter<VHolder>() {
    private var isPlaying = false

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val holder = VHolder(v)

        v.setOnClickListener {
            //ถ้ากำลังเล่นไฟล์อื่นอยู่ในขณะนั้น ก็ไม่ต้องเล่นไฟล์ที่พึ่งถูกคลิก
            if (isPlaying) {
                return@setOnClickListener
            }

            val pos = holder.adapterPosition
            val rt = data[pos].ringtoneId
            val mp = MediaPlayer.create(v.context, rt)
            mp.start()
            isPlaying = true
            //ถ้าเล่นไฟล์จบแล้ว ก็เปลี่ยนค่าของตัวแปรสถานะ ให้สอดคล้องกัน
            mp.setOnCompletionListener {
                isPlaying = false
            }
        }

        return holder
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.textTitle.text = data[position].title
    }
}
