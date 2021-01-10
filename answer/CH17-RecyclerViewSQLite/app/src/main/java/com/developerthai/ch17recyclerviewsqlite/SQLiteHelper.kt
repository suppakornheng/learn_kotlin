package com.developerthai.ch17recyclerviewsqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper private constructor(context: Context)
        : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private val DB_NAME = "mydb"
        private val DB_VERSION = 1
        private var sqliteHelper: SQLiteHelper? = null

        //เมธอดสำหรับสร้างอินสแตนซ์ของคลาสนี้
        @Synchronized
        fun getInstance(c: Context): SQLiteHelper {
            return if (sqliteHelper == null) {
                SQLiteHelper(c.applicationContext)
            } else {
                sqliteHelper!!
            }
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        var sql = """CREATE TABLE emergency_call (
                            _id INTEGER PRIMARY KEY AUTOINCREMENT,
                            name TEXT,
                            phone TEXT UNIQUE)"""

        db.execSQL(sql)

        //ข้อมูลเริ่มแรกของตาราง
        sql = """INSERT INTO emergency_call(_id, name, phone) VALUES
                         (null, 'เหตุด่วนเหตุร้ายทุกชนิด', '191'),
                         (null, 'เพลิงไหม้', '199'),
                         (null, 'แพทย์ฉุกเฉิน', '1669'),
                         (null, 'จส. 100', '1137'),
                         (null, 'ตำรวจทางหลวง', '1193')"""

        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, v1: Int, v2: Int) {

    }
}
