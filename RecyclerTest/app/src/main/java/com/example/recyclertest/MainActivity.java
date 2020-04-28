package com.example.recyclertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);//表示使用线性布局
        recyclerView.setLayoutManager(manager);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void init(){
        for(int i = 0;i<2;i++){
            Fruit apple = new Fruit("苹果",R.drawable.apple);
            fruitList.add(apple);
            Fruit apple1 = new Fruit("苹果",R.drawable.apple);
            fruitList.add(apple1);
            Fruit apple2 = new Fruit("苹果",R.drawable.apple);
            fruitList.add(apple2);
            Fruit apple3 = new Fruit("苹果",R.drawable.apple);
            fruitList.add(apple3);
            Fruit apple4 = new Fruit("苹果",R.drawable.apple);
            fruitList.add(apple4);
            Fruit apple5 = new Fruit("苹果",R.drawable.apple);
            fruitList.add(apple5);
        }
    }
}
