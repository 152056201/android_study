package com.example.notetest;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    private Context mcontext;
    private Cursor mcursor;
    private LinearLayout mLayout;
    public MyAdapter(Context context,Cursor cursor){
        this.mcursor = cursor;
        this.mcontext = context;
    }
    @Override
    public int getCount() {
        return mcursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return mcursor.getPosition();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        mLayout = (LinearLayout) inflater.inflate(R.layout.list_activity,null);
        TextView content = mLayout.findViewById(R.id.list_content);
        TextView time = mLayout.findViewById(R.id.list_time);
        mcursor.moveToPosition(position);
        String dbcontext = mcursor.getString(mcursor.getColumnIndex("content"));
        String dbtime = mcursor.getString(mcursor.getColumnIndex("time"));
        content.setText(dbcontext);
        time.setText(dbtime);
        return mLayout;
    }
}
