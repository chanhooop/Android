package com.aoslec.quiz0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnRed, btnGreen, btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRed = findViewById(R.id.btnRed);
        Toast.makeText(MainActivity.this, "빨간버튼입니다", Toast.LENGTH_SHORT).show();


    }
}