package com.developerthai.ch15contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img = findViewById<ImageView>(R.id.imageView)
        registerForContextMenu(img)
    }

    override  fun onCreateContextMenu(contextMenu: ContextMenu?, v: View?, info: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(contextMenu, v, info)
        menuInflater.inflate(R.menu.menu_context, contextMenu)     //แปลง XML เป็น Object
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_edit, R.id.menu_share, R.id.menu_delete -> {
                toast(item.title)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toast(msg: CharSequence) {
        Toast.makeText(baseContext, msg, Toast.LENGTH_LONG).show()
    }
}
