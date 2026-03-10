package com.example.register

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RegisterHelper(context: Context) :
    SQLiteOpenHelper(context, "RegisterDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        val createTable = "CREATE TABLE register (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "firstname TEXT," +
                "lastname TEXT," +
                "phone TEXT," +
                "gender TEXT)"

        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS register")
        onCreate(db)
    }

    fun insertData(firstname: String, lastname: String, phone: String,gender: String): Boolean {

        val db = this.writableDatabase
        val values = ContentValues()

        values.put("firstname", firstname)
        values.put("lastname", lastname)
        values.put("phone", phone)
        values.put("gender", gender)


        val result = db.insert("register", null, values)

        return result != -1L
    }

    fun getAllData() =
        readableDatabase.rawQuery("SELECT * FROM register", null)

}