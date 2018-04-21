package com.codingblocks.animationtransition

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.Button

class MyButton : android.support.v7.widget.AppCompatButton {


    constructor(context: Context) : super(context) {
        Log.d("BTN", "context")
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        Log.d("BTN", "context, attrs")
        var text = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text")
        Log.d("BTN", "text = ${text}")


    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        Log.d("BTN", "context, attrs, defStyleAttr")
    }
}
