package com.mml.androidreboot;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import com.mml.androidreboot.helpers.Helpers;
import com.mml.androidreboot.broadcasts.RebootService;

import java.util.Calendar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createAlarm();
    }

    protected void createAlarm() {
        Intent rebootIntent = new Intent(getApplicationContext(), RebootService.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Helpers.calendar();

        PendingIntent rebootPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, rebootIntent, PendingIntent.FLAG_ONE_SHOT);

        alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, rebootPendingIntent);
    }
}
