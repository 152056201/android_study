package com.example.brodacasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver offlineReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionController.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.brodacasttest.FORCE_OFFLINE");
        offlineReceiver = new ForceOfflineReceiver();
        registerReceiver(offlineReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (offlineReceiver != null) {
            unregisterReceiver(offlineReceiver);
            offlineReceiver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActionController.removeActivity(this);
    }

    class ForceOfflineReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, Intent intent) {
            //构建对话框
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("WRANNING");
            builder.setMessage("您在异地登陆，请重新登陆");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActionController.finishedAll();//销毁所有活动
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }
            });
            builder.show();
        }
    }
}
