package com.example.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String newId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addBtn = findViewById(R.id.button_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.databasetest.provider/book");
                ContentValues values = new ContentValues();
                values.put("name", "A Clash of Kings");
                values.put("author", "Martin");
                values.put("pages", 250);
                values.put("price", 25.26);
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
            }
        });
        Button queryBut = findViewById(R.id.button_select);
        queryBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.databasetest.provider/book");
                Cursor cursor = getContentResolver().query(uri, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        Integer pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        Double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity", "name=" + name);
                        Log.d("MainActivity", "author=" + author);
                        Log.d("MainActivity", "pages=" + pages);
                        Log.d("MainActivity", "price=" + pages);
                    }
                    cursor.close();
                }
            }
        });
        Button updateBtn = findViewById(R.id.button_update);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.databasetest.provider/book/"+newId);
                ContentValues contentValues = new ContentValues();
                contentValues.put("name","iM IS Ok");
                contentValues.put("pages",230);
                contentValues.put("price",15.23);
                getContentResolver().update(uri,contentValues,null,null);
            }
        });
        Button delBtn = findViewById(R.id.button_remove);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.databasetest.provider/book/"+newId);
                getContentResolver().delete(uri,null,null);
            }
        });
    }
}
