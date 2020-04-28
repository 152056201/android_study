package com.example.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruits);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruits.get(position);
                Intent intent = new Intent(MainActivity.this, ShowFruit.class);
                intent.putExtra("apple",fruit.getName());
                startActivity(intent);
            }
        });

    }

    private void init() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("苹果", R.drawable.apple);
            fruits.add(apple);
            Fruit apple1 = new Fruit("苹果", R.drawable.apple);
            fruits.add(apple1);
            Fruit apple2 = new Fruit("苹果", R.drawable.apple);
            fruits.add(apple2);
            Fruit apple3 = new Fruit("苹果", R.drawable.apple);
            fruits.add(apple3);
            Fruit apple4 = new Fruit("苹果", R.drawable.apple);
            fruits.add(apple4);
            Fruit apple5 = new Fruit("苹果", R.drawable.apple);
            fruits.add(apple5);
            Fruit apple6 = new Fruit("苹果", R.drawable.apple);
            fruits.add(apple6);

        }
    }
}
