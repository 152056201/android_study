package com.example.adaptertest;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ArrayAdapterActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] args = {"1","2","3","4","5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,args);
        setListAdapter(adapter);
    }
}
