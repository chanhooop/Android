package com.aoslec.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button dogbutton, catbutton;
    ImageView dogimg, catimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogbutton = findViewById(R.id.dogbutton);
        catbutton = findViewById(R.id.catbutton);
        dogimg = findViewById(R.id.dogimg);
        catimg = findViewById(R.id.catimg);



        dogbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogimg.setVisibility(v.VISIBLE);
                catimg.setVisibility(v.INVISIBLE);
            }
        });

        catbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catimg.setVisibility(v.VISIBLE);
                dogimg.setVisibility(v.INVISIBLE);
            }
        });
    }
}