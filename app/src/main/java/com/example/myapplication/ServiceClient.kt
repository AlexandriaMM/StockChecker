package com.example.myapplication

import android.app.Activity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.util.AbstractQueue


object ServiceClient {
    private lateinit var queue: RequestQueue

    public fun initQueue(mainActivity: Activity){
        queue = Volley.newRequestQueue(mainActivity.applicationContext)
    }

    public fun sendRequest(request: Request <JSONObject>){
        queue.add(request)
    }

}