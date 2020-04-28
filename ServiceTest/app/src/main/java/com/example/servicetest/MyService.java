package com.example.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {
    private DownloadBinder mBindr = new DownloadBinder();
    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("MyService", "startDownload");
        }
        public int getProgress(){
            Log.d("MyService", "getProgress");
            return 0;
        }
    }
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "onCreate");
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this).
                setContentTitle("This is a content title").
                setContentText("This is content text").
                setWhen(System.currentTimeMillis()).
                setSmallIcon(R.mipmap.ic_launcher).
                setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)).
                setContentIntent(pendingIntent).build();
        startForeground(1,notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBindr;
    }
}
