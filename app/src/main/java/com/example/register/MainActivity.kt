package com.example.register

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.list_items)
        val items = listOf("BCA", "MCA", "MSC IT", "MBA")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            items
        )
        listView.adapter = adapter

        val registerBtn = findViewById<Button>(R.id.btn_register)
        val firstName = findViewById<EditText>(R.id.edt_firstname)
        val lastName = findViewById<EditText>(R.id.edt_lastname)
        val phone  = findViewById<EditText>(R.id.edt_phone)
        val radioGroup = findViewById<RadioGroup>(R.id.rg_gender)
        val db = RegisterHelper(this)
        registerBtn.setOnClickListener {
            val fname = firstName.text.toString()
            val lname = lastName.text.toString()
            val ph = phone.text.toString()
            val selectedId = radioGroup.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(selectedId)
            val gender = radioButton.text.toString()
            db.insertData(fname,lname,ph,gender)
            Toast.makeText(this, "Register Successful", Toast.LENGTH_SHORT).show()
        }
    }
}
