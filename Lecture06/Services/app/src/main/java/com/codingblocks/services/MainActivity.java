package com.codingblocks.services;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "ACT";
    Button btnStartService, btnStopService, btnWait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent srvIntent = new Intent(MainActivity.this, MyService.class);

        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);
        btnWait = findViewById(R.id.btnWait);


        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(srvIntent);
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(srvIntent);

            }
        });

        btnWait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                waitNSec(10);
//                Toast.makeText(MainActivity.this, "WAIT CLICKED", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, MyIntentService.class);
                startService(i);
            }
        });
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
}
