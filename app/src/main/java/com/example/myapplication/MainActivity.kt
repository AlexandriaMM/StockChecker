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
        val responseLabel = findViewById<TextView>(R.id.responselbl)
        val stockSymbolText = stockSymbol.text.toString()
        val jsonObject = JSONObject()
        jsonObject.put("stockSymbol", stockSymbolText)
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            var previousStockPrice: Double? = null
            override fun run() {
                ServiceClient.get(stockSymbolText,
                    Response.Listener {
                        Log.i("stockPrice", it.getString("stockPrice"))
                        runOnUiThread {
                            val stockPrice = it.getDouble("stockPrice")
                            updateUI(stockSymbolText, stockPrice, previousStockPrice)
                            previousStockPrice = stockPrice
                            /*responseLabel.setText(stockSymbolText + " " + it.getString("stockPrice"))*/
                        }
                    },
                    Response.ErrorListener {
                        Log.e("stockPrice", it.message.toString())
                    }
                )
            }
        }, 0, 5000)
    }

    private fun updateUI(stockSymbol: String, stockPrice: Double, maybePreviousStockPrice: Double?) {
        val previousStockPrice = maybePreviousStockPrice ?: stockPrice;

        val responseLabel = findViewById<TextView>(R.id.responselbl)
        responseLabel.text = "$stockSymbol $stockPrice"

        if (previousStockPrice != null) {
            val color = when {
                stockPrice > previousStockPrice -> R.color.green
                stockPrice < previousStockPrice -> R.color.red
                else -> R.color.black
            }
            responseLabel.setTextColor(resources.getColor(color, null))
        }
    }
}

