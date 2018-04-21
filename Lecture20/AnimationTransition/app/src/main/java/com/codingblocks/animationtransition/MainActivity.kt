package com.codingblocks.animationtransition

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = MyButton(this)
        btn.text = "A"
        llBackground.addView(btn)

        llBackground.addView(MyButton(this).apply {
            text = "B"
        })

    }
}
