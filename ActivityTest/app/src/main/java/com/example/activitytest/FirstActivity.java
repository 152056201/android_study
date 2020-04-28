package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id =" + getTaskId());
        setContentView(R.layout.first_layout);  //给当前活动加载一个页面布局
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "点击button1", Toast.LENGTH_SHORT).show();
                //显示Intent
                //Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //隐式Intent
                //Intent intent = new Intent("com.example.activitytest.ACTION_START");
                //intent.addCategory("com.example.activitytest.MY_CATEGORY");
                //跳转网页
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //将数据传递给下一个activity
                /*String data = "hello SeondActivity";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);*/
                //体验standard默认活动启动模式
                //Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
                //singleTop启动模式
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                //Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //startActivityForResult(intent,1);
            }
        });
        //销毁活动
        /*button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You Click Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You Click Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    /**
     * 得到SecondActivity返回的数据
     *
     * @param requestCode 启动活动时传递的请求码
     * @param resultCode  返回的数据时传入的数据结果
     * @param data        携带返回数据的intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d(TAG, returnData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart FirstActivity");
    }
}
