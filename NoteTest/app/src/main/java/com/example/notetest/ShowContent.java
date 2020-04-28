package com.example.notetest;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ShowContent extends AppCompatActivity {
    private TextView mTextView;
    private TextView time;
    private NoteDb db;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        mTextView = this.findViewById(R.id.showtext);
        time = this.findViewById(R.id.showtime);
        db = new NoteDb(this);
        db.getWritableDatabase();
        mTextView.setText(getIntent().getStringExtra(NoteDb.CONTENT));
        time.setText(getIntent().getStringExtra(NoteDb.TIME));
    }

    public void delete(View view) {
        int id = getIntent().getIntExtra(NoteDb.ID, 0);
        database.delete(NoteDb.TABLE_NAME, "id= " + id, null);
        finish();
    }

    public void goBack(View view) {
        finish();
    }
}
