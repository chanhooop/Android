package com.aoslec.frametest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(img.getVisibility() == v.INVISIBLE){
                    img.setVisibility(v.VISIBLE);
                }else {
                    img.setVisibility(v.INVISIBLE);
                }
            }
        });


    }
}