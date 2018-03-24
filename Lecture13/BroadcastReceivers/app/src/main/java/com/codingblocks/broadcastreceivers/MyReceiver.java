package com.codingblocks.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public static final String TAG = "RCV";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent != null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            boolean airplaneMode = intent.getBooleanExtra("state", false);
            Log.d(TAG, "onReceive: airplane mode = " + airplaneMode);
        }
    }
}
