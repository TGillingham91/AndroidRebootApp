package com.mml.androidreboot.broadcasts;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.mml.androidreboot.helpers.Helpers;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class AlarmService extends JobIntentService {

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Intent rebootIntent = new Intent(this, RebootService.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Helpers.calendar();

        PendingIntent pendingRebootIntent = PendingIntent.getService(getApplicationContext(), 0, rebootIntent, PendingIntent.FLAG_ONE_SHOT);

        alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingRebootIntent);
    }
}
