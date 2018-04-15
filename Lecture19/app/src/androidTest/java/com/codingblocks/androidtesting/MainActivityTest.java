package com.codingblocks.androidtesting;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void MainActivity_starts () {
        assertNotNull(mainActivityActivityTestRule.getActivity());
    }

    @Test
    public void MainActivity_calcFare_works () {
        final MainActivity mainActivity = mainActivityActivityTestRule.getActivity();

        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivity.et1.setText("3");
                mainActivity.et2.setText("20");
                mainActivity.btn.performClick();
                float fare = Float.valueOf(mainActivity.tv.getText().toString());
                assertEquals(40F, fare, 0.005F);
            }
        });


    }

}
