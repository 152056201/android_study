package com.example.getedittext;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.edittext);
        imageView = findViewById(R.id.imageview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        Toast.makeText(MainActivity.this,editText.getText().toString(),Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.p1);
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("操作");
                        builder.setMessage("是否删除");
                        builder.setCancelable(false);
                        //设置确定点击
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                progressDialog.setTitle("请等待");
                                progressDialog.setMessage("正在执行");
                                progressDialog.setCancelable(true);
                                progressDialog.show();
                            }
                        });
                        //设置取消点击
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.show();
                        break;
                    default:
                        break;

                }
            }
        });
    }
}
