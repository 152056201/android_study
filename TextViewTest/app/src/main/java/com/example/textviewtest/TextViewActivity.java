package com.example.textviewtest;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTv4 = findViewById(R.id.tv_4);
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
        mTv4.getPaint().setAntiAlias(true); //去除锯齿
    }
}
