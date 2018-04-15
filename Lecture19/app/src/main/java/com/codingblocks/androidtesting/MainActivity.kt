package com.codingblocks.androidtesting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button;
    lateinit var et1: EditText;
    lateinit var et2: EditText;
    lateinit var tv: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = btnCalcFare
        et1 = etKm
        et2 = etMin
        tv = tvFare

        btnCalcFare.setOnClickListener {
            val km = etKm.text.toString().toFloat()
            val min = etMin.text.toString().toInt()
            tvFare.text = FareUtils.calcFare(km, min).toString()
        }
    }

}
