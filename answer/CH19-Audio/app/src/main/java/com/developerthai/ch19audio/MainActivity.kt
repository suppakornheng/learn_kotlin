package com.developerthai.ch19audio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val mp = MediaPlayer.create(baseContext, R.raw.bird_tone)
        //mp.start()
        /*
        val path = "android.resource://$packageName/${R.raw.song_2015}"
        val uri = Uri.parse(path)
        MediaPlayer().apply {
            setDataSource(baseContext, uri)
            prepare()
            start()
        }
        */

        val items = mutableListOf<Item>()
        items.add(Item("Amazing Ring Tone", R.raw.amazing_ringtone))
        items.add(Item("Best Tone", R.raw.best_tone))
        items.add(Item("Bird Tone", R.raw.bird_tone))
        items.add(Item("Chop Down Violins", R.raw.chop_down_violins))
        items.add(Item("Cowboy Whistle", R.raw.cowboy_whistle))
        items.add(Item("Exorcist Theme", R.raw.exorcist_theme))
        items.add(Item("Guitar 2013", R.raw.guitar_2013))
        items.add(Item("iOS 7", R.raw.ios_7))
        items.add(Item("iPhone 5", R.raw.iphone_5))
        items.add(Item("Magic Tone", R.raw.magic_tone))
        items.add(Item("Nice Ring Tone", R.raw.nice_ringtone_2017))
        items.add(Item("Numb Piano", R.raw.numb_piano))
        items.add(Item("Perfect Tone", R.raw.perfect_tone))
        items.add(Item("Pop Rock Drums", R.raw.poprock_drums))
        items.add(Item("Song 2015", R.raw.song_2015))
        items.add(Item("Sony Xperia", R.raw.sony_xperia))
        items.add(Item("Trap Android", R.raw.trap_android))
        items.add(Item("Very Nice Alarm", R.raw.very_nice_alarm))
        items.add(Item("Whistle", R.raw.whistle))
        items.add(Item("Wolf Howl", R.raw.wolf_howl))

        val adapter = Adapter(items)
        val rcv = findViewById<RecyclerView>(R.id.recyclerView)
        rcv.layoutManager = LinearLayoutManager(this)
        rcv.adapter = adapter

        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rcv.addItemDecoration(itemDecor)
    }
}
