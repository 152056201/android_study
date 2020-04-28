package com.example.addresstest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StudentDBOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mydb"; //库名
    public static final String TABLE_NAME = "friends"; //表名

    //数据库列名
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String CREATE_SQL = "create table " + TABLE_NAME + "(" + ID + " integer primary key autoincrement," +
            NAME + " text ," + PHONE + " text)";

    public StudentDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("StudentDBOpenHelper", "数据库创建成功");
        db.execSQL(CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("StudentDBOpenHelper", "数据库更新");
        db.execSQL("DROP TABLE if EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
