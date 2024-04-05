package com.example.services;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Background service intent
        /* Intent bgIntent = new Intent(this, foregroundService.class); */

        // foreground service intent
        Intent fgIntent = new Intent(this, backgroundService.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //Starting the background service
            /* startService(bgIntent); */

            //Starting the foreground service
            if (!foregroundServiceRunning()) {
                startForegroundService(fgIntent);
            }
        }
    }

    // We use this method to check if the service is already running
    public boolean foregroundServiceRunning() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service: activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (foregroundService.class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}