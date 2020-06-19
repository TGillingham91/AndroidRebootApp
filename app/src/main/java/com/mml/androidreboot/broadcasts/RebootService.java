package com.mml.androidreboot.broadcasts;

import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class RebootService extends JobIntentService {
    private static final String TAG = "RebootService: ";

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        try {
            PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
            pm.reboot(null);
        } catch(Exception e) {
            Log.d(TAG, "Failed to Reboot device - " + e.getMessage());
        }
    }
}
