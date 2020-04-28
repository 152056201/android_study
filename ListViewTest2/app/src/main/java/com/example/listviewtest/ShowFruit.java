package com.example.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowFruit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_fruit);
        TextView textView = findViewById(R.id.name);
        Intent intent = new Intent();
        String apple = intent.getStringExtra("apple");


    }
}
