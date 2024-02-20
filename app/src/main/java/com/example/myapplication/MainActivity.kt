package com.example.myapplication
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.JsonRequest
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ServiceClient.initQueue(this)
    }

    public fun buttonTapped(view: View) {
        val stockSymbol = findViewById<EditText>(R.id.stockInputText)
        val stockSymbolText = stockSymbol.text.toString()
        val jsonObject = JSONObject()
        jsonObject.put("stockSymbol", stockSymbolText)
        val timer = Timer()
        timer.scheduleAtFixedRate(object:TimerTask(){
            override fun run() {
                ServiceClient.get(jsonObject,
                    Response.Listener {
                        Log.i("stockPrice", it.getString("stockPrice"))
                        runOnUiThread{
                            stockSymbol.setText(it.getString("stockPrice"))
                        }
                    },
                    Response.ErrorListener {
                        Log.e("stockPrice", it.message.toString())
                    }
                )
            }
        }, 0, 5000)
    }
}
