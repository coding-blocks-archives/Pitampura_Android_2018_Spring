package com.codingblocks.androidtesting


import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_main.*

import org.junit.Assert.*

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @JvmField @Rule
    var mainActivityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun MainActivity_starts() {
        assertNotNull(mainActivityActivityTestRule.activity)
    }

    @Test
    fun MainActivity_calcFare_works() {
        val mainActivity = mainActivityActivityTestRule.activity

        mainActivity.runOnUiThread {
            mainActivity.etKm.setText("3")
            mainActivity.etMin.setText("20")
            mainActivity.btnCalcFare.performClick()
            val fare = mainActivity.tvFare.toString().toFloat()
            assertEquals(40f, fare, 0.005f)
        }


    }

}
