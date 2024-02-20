package com.example.myapplication

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.util.Timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ServiceClient.initQueue(this)
    }

    public fun buttonTapped(view: View) {
        val stockSymbol = findViewById<EditText>(R.id.stockInputText).text.toString()
        val jsonObject = JSONObject()

        val timer = Timer()
        timer.scheduleAtFixedRate(object:TimerTask(){
            override fun run() {
                ServiceClient.sendRequest(jsonRequest)
            }
        }, 0, 5000)

        jsonObject.get("stockSymbol," stockSymbol)
    }

}
