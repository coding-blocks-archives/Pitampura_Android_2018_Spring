package com.codingblocks.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public static final String TAG = "SRV";
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int retCode = super.onStartCommand(intent, flags, startId);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 1000);
        Log.d(TAG, "onStartCommand: ");
        return retCode;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
