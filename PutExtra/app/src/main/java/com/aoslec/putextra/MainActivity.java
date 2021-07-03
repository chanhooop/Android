package com.aoslec.putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int RValue = 0;
    TextView textView = null;
    Button button = null;
    Button button1 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_main);
        button = findViewById(R.id.btn_main);
        button1 = findViewById(R.id.btn_main2);

        button.setOnClickListener(onClickListener);
        button1.setOnClickListener(onClickListener);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };


    }


}