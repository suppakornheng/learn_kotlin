package com.developerthai.todolist

import android.content.Context
import android.database.Cursor
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Adapter(val data: Cursor) : RecyclerView.Adapter<VHolder>() {
    override fun getItemCount(): Int = data.count

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val holder = VHolder(v)

        holder.imgTrash.setOnClickListener {
            AlertDialog.Builder(parent.context).apply {
                setMessage("ต้องการลบข้อมูลรายการนี้จริงหรือไม่?")
                setPositiveButton("ตกลง", { dialog, which ->
                    val pos = holder.adapterPosition
                    deleteItem(pos, parent.context)
                })
                setNegativeButton("ยกเลิก", { _, _ ->
                    //...
                }).show()
            }
        }
        return holder
    }


    override fun onBindViewHolder(holder: VHolder, position: Int) {
        data.moveToPosition(position)
        holder.textTitle.text = data.getString(1)
        val time = data.getLong(2)
        val cal = Calendar.getInstance()
        cal.time = Date(time)

        val bgColor = Color.argb(255, r(), r(), r())
        val gd = holder.textDate.background as GradientDrawable
        gd.setColor(bgColor)

        val day = cal.get(Calendar.DAY_OF_MONTH)
        val dayStr = if (day >= 10) "$day" else "0$day"
        holder.textDate.text = dayStr

        val m = getMonthName(cal.get(Calendar.MONTH))
        val y = cal.get(Calendar.YEAR) + 543
        holder.textMonthYear.text = "$m $y"
    }

    private var mRand = kotlin.random.Random
    private fun r()  = mRand.nextInt(256)

    private fun getMonthName(month: Int): String? {
        val m = arrayOf(
            "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน",
            "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม")

        return if (month in 0..11) m[month] else null
    }

    private fun deleteItem(pos: Int, context: Context) {
        data.moveToPosition(pos)
        val id = data.getInt(0)

        val sqliteHelper = SQLiteHelper.getInstance(context)
        val db = sqliteHelper.writableDatabase
        val sql = "DELETE FROM todo WHERE _id = $id"
        db.execSQL(sql)

        val mainActivity = context as MainActivity
        mainActivity.readDatabaseToRecyclerView()
    }
}
