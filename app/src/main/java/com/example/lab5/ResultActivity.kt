package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val convertedPrice = intent.getDoubleExtra("CONVERTED_PRICE", 0.0)

        textViewResult.text = "Цена = %.2f руб.".format(convertedPrice)
    }
}