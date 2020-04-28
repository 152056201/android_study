package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruits = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiFruits();
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item_activity, fruits);
        ListView listView = (ListView) findViewById(R.id.fruit_item);
        listView.setAdapter(fruitAdapter);
        //ArrayAdapter适配器
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,datas);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruits.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void intiFruits(){
        for(int i = 0;i<2;i++){
            Fruit apple = new Fruit("Apple",R.drawable.a);
            fruits.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.a);
            fruits.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.a);
            fruits.add(orange);
            Fruit peal = new Fruit("Peal",R.drawable.a);
            fruits.add(peal);
            Fruit pruple = new Fruit("Purple",R.drawable.a);
            fruits.add(pruple);
            Fruit lemon = new Fruit("Lemon",R.drawable.a);
            fruits.add(lemon);
            Fruit peak = new Fruit("Peak",R.drawable.a);
            fruits.add(peak);
            Fruit water = new Fruit("Water",R.drawable.a);
            fruits.add(water);
            Fruit meat = new Fruit("Meat",R.drawable.a);
            fruits.add(meat);
            Fruit milk = new Fruit("Milk",R.drawable.a);
            fruits.add(milk);
        }
    }
}
