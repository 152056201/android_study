package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Log.d(TAG, "Task id=" + getTaskId());
        //接收FirstActivity的数据
        /*Intent intent = getIntent();
        String extra_data = intent.getStringExtra("extra_data");
        Log.d(TAG, extra_data);*/
        Button button = findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "点击SecondActivity的button", Toast.LENGTH_LONG).show();
                //向FirstActivity传递数据
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("data_return", "Hello FirstActivity");
                setResult(RESULT_OK, intent);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "HI FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
