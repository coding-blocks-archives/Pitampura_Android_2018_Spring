package com.codingblocks.animationtransition

import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.romainpiel.titanic.library.Titanic
import com.romainpiel.titanic.library.TitanicTextView
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

        ivRotateProgress.apply {
            setBackgroundResource(R.drawable.ic_progress_rotate)
            (background as AnimationDrawable).start()
        }
        Titanic().start(tvTitanic as TitanicTextView)

    }
}
