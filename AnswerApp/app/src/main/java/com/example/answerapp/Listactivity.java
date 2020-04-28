package com.example.answerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Listactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listprj);
        final String[] year = {"2018上半年","2018下半年",
                "2017上半年","2017下半年","2016上半年","2016下半年","2015上半年",
                "2015下半年","2014上半年","2014下半年","2013上半年","2013下半年",
                "2012上半年","2012下半年","2011上半年","2011下半年","2010上半年",
                "2010下半年"};
        ListView lv = (ListView)findViewById(R.id.listkm);
        ArrayAdapter<String> adpterar = new ArrayAdapter<String>(Listactivity.this,android.R.layout.simple_list_item_1,year);
        lv.setAdapter(adpterar);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int tem = position;
                switch (tem){
                    case 0:
                        Intent all = new Intent(Listactivity.this,Answeractivity.class);
                        startActivity(all);
                        break;
                }
            }
        });
    }
}
