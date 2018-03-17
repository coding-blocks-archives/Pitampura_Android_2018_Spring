package com.codingblocks.consumerestapi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.codingblocks.consumerestapi.activities.UsersActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnUsers.setOnClickListener {
            startActivity(Intent(this, UsersActivity::class.java))
        }
    }
}
