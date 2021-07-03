package com.aoslec.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ToolBarFragment.ToolbarListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onButtonClik(int postion, String text) {
        TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_2);
        textFragment.changeTextProperties(postion,text);
    }
}