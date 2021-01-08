package com.developerthai.ch18googlemaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editPlace = findViewById<EditText>(R.id.editText_place)
        val editZoom = findViewById<EditText>(R.id.editText_zoom)

        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                val q = editPlace.text.toString()
                if (q.isEmpty()) {
                    toast("กรุณาระบุสถานที่")
                    return@setOnClickListener
                }

                 var z  = editZoom.text.toString()
                if (z.isEmpty()) {
                    z = "15"
                }

                val geo = "geo:0,0?q=$q&z=$z"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(geo)
                intent.setPackage("com.google.android.apps.maps")
                startActivity(intent)
            }
        }
    }

    private fun toast(msg: String) {
        Toast.makeText(baseContext, msg, Toast.LENGTH_LONG).show()
    }

}
