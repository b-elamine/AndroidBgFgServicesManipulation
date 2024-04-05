package com.example.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class broadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // Using the code below, we can restart the service automatically after reboot
        // Uncomment to test ..

        /*

        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            Intent fgIntent = new Intent(context, foregroundService.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(fgIntent);
            }

        }*/
    }
}
