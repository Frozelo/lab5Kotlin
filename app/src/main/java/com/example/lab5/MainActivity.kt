package com.example.lab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextPrice = findViewById<EditText>(R.id.editTextPrice)
        val radioGroupCurrency = findViewById<RadioGroup>(R.id.radioGroupCurrency)
        val buttonConvert = findViewById<Button>(R.id.buttonConvert)

        buttonConvert.setOnClickListener {
            val price = editTextPrice.text.toString().toDoubleOrNull() ?: 0.0
            val selectedCurrencyId = radioGroupCurrency.checkedRadioButtonId
            val exchangeRate = when (selectedCurrencyId) {
                R.id.radioButtonUSD -> 75.0
                R.id.radioButtonEUR -> 90.0
                R.id.radioButtonGBP -> 100.0
                else -> 1.0
            }

            val convertedPrice = price * exchangeRate

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("CONVERTED_PRICE", convertedPrice)
            startActivity(intent)
        }
    }
}