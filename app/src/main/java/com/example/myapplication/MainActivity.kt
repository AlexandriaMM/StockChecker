package com.example.myapplication

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ServiceClient.initQueue(this)
    }

    public fun buttonTapped(view: View) {
        val stockSymbol = findViewById<TextView>(R.id.stockInputText).text.toString()
        val jsonObject = JSONObject()
        val myButton =


        jsonObject.get("stockSymbol," stockSymbol)
    }
}
