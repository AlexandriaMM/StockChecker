package com.example.myapplication

import android.R
import android.os.Bundle
<<<<<<< HEAD
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

=======
import java.util.Timer
>>>>>>> 02e2734103f6f3bfc9f6e3a5ba8ba9deb566e14c

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ServiceClient.initQueue(this)
    }

<<<<<<< HEAD
    public fun buttonTapped(view: View) {
        val stockSymbol = findViewById<TextView>(R.id.stockInputText).text.toString()
        val jsonObject = JSONObject()
        val myButton =


        jsonObject.get("stockSymbol," stockSymbol)
    }
=======
    val timer = Timer()
    timer.scheduleAtFixedRate(object:TimerTask(){
        override fun run() {
            ServiceClient.sendRequest(jsonRequest)
        }
    }, 0, 5000)

>>>>>>> 02e2734103f6f3bfc9f6e3a5ba8ba9deb566e14c
}
