package com.developerthai.ch15optionsmenu

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import android.text.Spanned
import android.text.style.ImageSpan
import android.text.SpannableStringBuilder
import java.nio.file.Files.size
import android.graphics.Color.parseColor
import android.text.style.ForegroundColorSpan
import android.graphics.drawable.Drawable


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_main,  R.id.action_products -> {
                toast(item.title.toString());
                true
            }
            R.id.action_order_and_pay -> {
                snackbar(item.title.toString())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toast(msg: String) {
        Toast.makeText(baseContext, msg, Toast.LENGTH_LONG).show()
    }

    private fun snackbar(msg: String) {
        Snackbar.make(fab, msg, Snackbar.LENGTH_LONG).show()
    }
}
