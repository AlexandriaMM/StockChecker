package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    val timer = Timer()
    timer.scheduleAtFixedRate(object:TimerTask(){
        override fun run() {
            ServiceClient.sendRequest(jsonRequest)
        }
    }, 0, 5000)

}
