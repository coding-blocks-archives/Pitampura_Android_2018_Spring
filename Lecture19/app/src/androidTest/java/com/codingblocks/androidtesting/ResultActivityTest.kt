package com.codingblocks.androidtesting

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_result.*
import org.junit.*
import org.junit.runner.RunWith

import org.junit.Assert.*;

@RunWith(AndroidJUnit4::class)
class ResultActivityTest {

    @JvmField @Rule
    val resultActivityTestRule =
            ActivityTestRule(ResultActivity::class.java)

    lateinit var resultActivity: ResultActivity

    @Before
    fun setup () {
        val intent = Intent()
        intent.putExtra("result", "50")

        resultActivity = resultActivityTestRule.launchActivity(intent)
    }

    @Test
    fun ResultActivity_result_is_shown () {
        assertEquals("50", resultActivity.tvResult.text)
    }
    @Test
    fun ResultActivity_can_change_result () {
        resultActivity.runOnUiThread {
            resultActivity.tvResult.text = "33"
            assertEquals("33", resultActivity.tvResult.text)
        }
    }

}