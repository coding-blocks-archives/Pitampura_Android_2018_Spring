package com.codingblocks.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fun a() = etVar1.text.toString().toInt()
        fun b() = etVar2.text.toString().toInt()
        val p = { etVar1.text.toString().toInt() }
        val q = { etVar2.text.toString().toInt() }

        btnAdd.setOnClickListener{
            tvResult.text = ( p() + q() ).toString()
        }
    }
}

//operator fun (() -> Int).plus(X: () -> Int): Int { return this() + X() }

