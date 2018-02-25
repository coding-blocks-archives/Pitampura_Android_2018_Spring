package com.codingblocks.services;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "ACT";
    Button btnStartService, btnStopService, btnWait;
    Intent srvIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        srvIntent = new Intent(MainActivity.this, MyService.class);

        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);
        btnWait = findViewById(R.id.btnWait);


        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        btnWait.setOnClickListener(this);
    }

    static void waitNSec (int n) {
        for (int i = 0; i < n; i++) {
            wait1Sec();
        }
    }
    static void wait1Sec() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + 1000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWait:
                Intent i = new Intent(MainActivity.this, MyIntentService.class);
                startService(i);
                break;
            case R.id.btnStartService:
                startService(srvIntent);
                break;
            case R.id.btnStopService:
                stopService(srvIntent);
                break;
        }
    }
}
