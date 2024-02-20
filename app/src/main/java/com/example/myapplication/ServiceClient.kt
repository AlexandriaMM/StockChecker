package com.example.myapplication

import android.app.Activity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.util.AbstractQueue


object ServiceClient {
    private lateinit var queue: RequestQueue

    private val url = "https://mopsdev.bw.edu/~bkrupp/330/assignments/stock.php"
    public fun initQueue(mainActivity: Activity){
        queue = Volley.newRequestQueue(mainActivity.applicationContext)
    }

    public fun sendRequest(request: Request <JSONObject>){
        queue.add(request)
    }

    public fun get(jsonObject: JSONObject,
                    listener: Response.Listener<JSONObject>,
                    errorListener: Response.ErrorListener) {
        val jsonRequest = JsonObjectRequest(Request.Method.GET,
            url,
            jsonObject,
            listener,
            errorListener)
    }
}