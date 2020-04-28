package com.example.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button_create);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });
        Button addBtn = findViewById(R.id.button_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setId(1);
                student.setAge(22);
                student.setName("yuanhao");
                student.setScore(99.56);
                student.setAuthor("James");
                student.save();

            }
        });
        Button updBtn = findViewById(R.id.button_update);
        updBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setScore(893.12);
                student.updateAll("name=?", "yuanhao");
            }
        });
        Button select = findViewById(R.id.button_select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> students = DataSupport.findAll(Student.class);
                for (Student s : students) {
                    Log.d("MainActivity", "id=" + s.getId());
                    Log.d("MainActivity", "name=" + s.getName());
                    Log.d("MainActivity", "author=" + s.getAuthor());
                    Log.d("MainActivity", "age=" + s.getAge());
                    Log.d("MainActivity", "score=" + s.getScore());
                }
            }
        });
    }
}
