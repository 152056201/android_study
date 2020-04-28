package com.example.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(fruits);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void intiFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.a);
            fruits.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.a);
            fruits.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.a);
            fruits.add(orange);
            Fruit peal = new Fruit(getRandomLengthName("Peal"), R.drawable.a);
            fruits.add(peal);
            Fruit pruple = new Fruit(getRandomLengthName("Purple"), R.drawable.a);
            fruits.add(pruple);
            Fruit lemon = new Fruit(getRandomLengthName("Lemon"), R.drawable.a);
            fruits.add(lemon);
            Fruit peak = new Fruit(getRandomLengthName("Peak"), R.drawable.a);
            fruits.add(peak);
            Fruit water = new Fruit(getRandomLengthName("Water"), R.drawable.a);
            fruits.add(water);
            Fruit meat = new Fruit(getRandomLengthName("Meat"), R.drawable.a);
            fruits.add(meat);
            Fruit milk = new Fruit(getRandomLengthName("Milk"), R.drawable.a);
            fruits.add(milk);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
