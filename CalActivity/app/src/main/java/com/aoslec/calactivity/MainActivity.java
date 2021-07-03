package com.aoslec.calactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.call);

        btnCall.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            Toast.makeText(MainActivity.this, "화면전환", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v("Message", "onCreate_Main");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        Log.v("Message", "onStart_Main");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v("Message", "onResume_Main");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Message", "onPause_Main");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("Message", "onStop_Main");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message", "onDestroy_Main");
        super.onDestroy();
    }
}