package com.example.brodacasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastRecevier extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"recrived in MyBroadcastRecevier",Toast.LENGTH_LONG).show();
    }
}
