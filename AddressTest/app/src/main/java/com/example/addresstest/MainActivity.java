package com.example.addresstest;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText et_name;
    private EditText et_phone;
    private ArrayList<Map<String, Object>> data;
    private SQLiteDatabase db;
    private ListView listView;
    private String  selId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        listView = findViewById(R.id.listView);
        Button addBtn = findViewById(R.id.bt_add);
        final Button updBtn = findViewById(R.id.bt_modify);
        Button delBtn = findViewById(R.id.bt_del);
        Button selBtn = findViewById(R.id.bt_sel);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdd();
                dbFindAll();
            }
        });
        updBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                dbFindAll();
            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbDel();
                dbFindAll();
            }
        });
        selBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbFindAll();
            }
        });
        StudentDBOpenHelper dbHelper = new StudentDBOpenHelper(this, StudentDBOpenHelper.DATABASE_NAME, null, 1);
        db = dbHelper.getWritableDatabase();
        data = new ArrayList<>();
        dbFindAll();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> listItem = (Map<String, Object>) listView.getItemAtPosition(position);
                et_name.setText((String) listItem.get("name"));
                et_phone.setText((String) listItem.get("phone"));
                selId = (String) listItem.get("id");
                Toast.makeText(getApplicationContext(), "选择的id是：" + selId, Toast.LENGTH_LONG).show();
            }
        });
    }

    protected void dbDel() {
        int i = db.delete("friends", "name=?", new String[]{et_name.getText().toString()});
        if (i > 0) {
            Toast.makeText(getApplicationContext(), "数据删除成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "数据删除失败", Toast.LENGTH_SHORT).show();
        }
    }

    //设置simpleAdapter在list_view中显示数据
    private void showList() {
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item, new String[]{"id", "name", "phone"},
                new int[]{R.id.tv_id, R.id.tv_name, R.id.tv_phone});
        listView.setAdapter(adapter);
    }

    protected void update() {
        ContentValues values = new ContentValues();
        values.put("phone", et_phone.getText().toString().trim());
        int i = db.update("friends", values, "name=?", new String[]{et_name.getText().toString()});
        Log.e("MainActivity", "数据修改好了");
        if (i > 0) {
            Toast.makeText(getApplicationContext(), "数据更新成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "数据更新失败", Toast.LENGTH_SHORT).show();
        }
    }

    protected void dbAdd() {
        ContentValues values = new ContentValues();
        values.put("name", et_name.getText().toString().trim());
        values.put("phone", et_phone.getText().toString().trim());
        long ll = db.insert(StudentDBOpenHelper.TABLE_NAME, null, values);
        if (ll == -1) {
            Toast.makeText(getApplicationContext(), "数据添加成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "数据添加失败", Toast.LENGTH_SHORT).show();
        }
    }

    protected void dbFindAll() {
        data.clear();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("select * from friends", null);
        Map<String, Object> item = new HashMap<>();
        item.put("id", "序号");
        item.put("name", "姓名");
        item.put("phone", "电话");
        data.add(item);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            item = new HashMap<>();
            item.put("id", id);
            item.put("name", name);
            item.put("phone", phone);
            data.add(item);
            cursor.moveToNext();
        }
        showList();
    }
}
