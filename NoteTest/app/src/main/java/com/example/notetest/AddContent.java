package com.example.notetest;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddContent extends AppCompatActivity {
    private EditText editText;
    private NoteDb mDb;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        editText = this.findViewById(R.id.text);
        mDb = new NoteDb(this);
        database = mDb.getWritableDatabase();
    }

    public void save(View view) {
        add();
        finish();
    }
    public void cancel(View view){
        editText.setText("");
        finish();
    }

    public void add() {
        ContentValues values = new ContentValues();
        values.put(NoteDb.CONTENT, editText.getText().toString());
        values.put(NoteDb.TIME, getTime());
        database.insert(NoteDb.TABLE_NAME, null, values);
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date();
        String str = sdf.format(date);
        return str;
    }
}
