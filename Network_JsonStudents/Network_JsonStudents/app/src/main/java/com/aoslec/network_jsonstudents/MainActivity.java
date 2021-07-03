package com.aoslec.network_jsonstudents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ListView listView;
    Button button;
    String urlAddr = "http://175.116.146.188:8080/test/students.json";
    ArrayList<JsonStudents> students;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
   // StudentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_main);
        recyclerView = findViewById(R.id.list_main);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        button.setOnClickListener(onClickListener);



    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr);
                Object obj = networkTask.execute().get();
                students = (ArrayList<JsonStudents>) obj;

                adapter = new StudentsAdapter(MainActivity.this, R.layout.custom_layout, students);
                recyclerView.setAdapter(adapter);
                button.setText("Results");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };


}