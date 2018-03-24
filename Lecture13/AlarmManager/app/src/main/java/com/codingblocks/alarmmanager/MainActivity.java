package com.codingblocks.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.Environment;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent startActIntent = new Intent(this, MainActivity.class);

        PendingIntent pi = PendingIntent.getActivity(
                this,
                112,
                startActIntent,
                PendingIntent.FLAG_ONE_SHOT
        );

//        am.setRepeating(
//                AlarmManager.RTC,
//                System.currentTimeMillis() + (60 * 1000),
//                2 * 60 * 1000,
//                pi
//        );
        am.set(
                AlarmManager.RTC,
                System.currentTimeMillis() + (60 * 1000),
                pi
        );


    }
}
