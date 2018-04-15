package com.codingblocks.androidtesting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcFare.setOnClickListener {
            val km = etKm.text.toString().toFloat()
            val min = etMin.text.toString().toInt()
            tvFare.text = FareUtils.calcFare(km, min).toString()
        }
    }

}
