package com.developerthai.ch17recyclerviewdrawable

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val data: List<Item>) : RecyclerView.Adapter<VHolder>() {
    private var mRand = kotlin.random.Random

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val holder = VHolder(v)
        return holder
    }

    //เมธอดสำหรับสร้างเลขวุ่มระหว่าง 0 - 255
    private fun r()  = mRand.nextInt(256)

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.apply {
            //อ่านอักขระตัวแรกไปแสดงบน TextView
            val firstLetter = data[position].name.substring(0, 1)
            txtDraw.text = firstLetter.toUpperCase()
            //สุ่มตัวเลขระหว่าง 0 - 255 มาสร้างเป็นสีแบบ ARGB แล้วกำหนดเป็นพื้นหลังของ TextView
            val bgColor = Color.argb(255, r(), r(), r())
            val gd = holder.txtDraw.getBackground() as GradientDrawable
            gd.setColor(bgColor)

            txtName.text = data[position].name
            txtEmail.text = data[position].email
        }
    }

}
