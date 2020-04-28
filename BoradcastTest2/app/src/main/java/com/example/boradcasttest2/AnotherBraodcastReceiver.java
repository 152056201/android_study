package com.example.boradcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 广播接收器
 */
public class AnotherBraodcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"recerived in anotherBroadcastReceiver",Toast.LENGTH_SHORT).show();
    }
}
