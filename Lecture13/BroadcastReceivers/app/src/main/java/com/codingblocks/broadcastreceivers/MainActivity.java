package com.codingblocks.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout flBackground;
    PowerConnectedReceiver pcr;
    IntentFilter powerEventFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flBackground = findViewById(R.id.flBackground);
        pcr = new PowerConnectedReceiver();

        powerEventFilter = new IntentFilter();
        powerEventFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        powerEventFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(pcr, powerEventFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(pcr);
    }

    class PowerConnectedReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
                    flBackground.setBackgroundColor(Color.GREEN);
                }
                if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
                    flBackground.setBackgroundColor(Color.RED);
                }
            }
        }
    }
}
