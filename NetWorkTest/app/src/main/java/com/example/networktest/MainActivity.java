package com.example.networktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.send_request);
        textView = findViewById(R.id.response_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.send_request){
                    sendRequestWithOKHttp();
                }

            }
        });
    }
    private void sendRequestWithOKHttp(){
       new Thread(new Runnable() {
           @Override
           public void run() {
               try{
                   OkHttpClient client = new OkHttpClient();
                   Request request = new Request.Builder().url("http://www.baidu.com").build();
                   Response response = client.newCall(request).execute();
                   String responseData = response.body().string();
                   showResponse(responseData);
               }catch (Exception e){

               }
           }
       }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(response);
            }
        });
    }
}
