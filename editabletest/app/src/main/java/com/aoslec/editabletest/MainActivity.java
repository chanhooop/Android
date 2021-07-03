package com.aoslec.editabletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etnum);
        //입력되어 있는 숫자

        Button btn1 = findViewById(R.id.ins);
        btn1.setOnClickListener(mClickListener);

        findViewById(R.id.del).setOnClickListener(mClickListener);
        findViewById(R.id.app).setOnClickListener(mClickListener);
        findViewById(R.id.rep).setOnClickListener(mClickListener);
        findViewById(R.id.clear).setOnClickListener(mClickListener);

    }  //onCreate
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Editable edit = editText.getText();
            //화면에 있는 값 가져오기
            switch (v.getId()){
                case  R.id.ins:
                    edit.insert(0,"INS");
                    break;
                case R.id.del:
                    edit.delete(2,5);
                    break;
                case R.id.app:
                    edit.append("APP");
                    break;
                case R.id.rep:
                    edit.replace(2,5,"REP");
                    break;
                case R.id.clear:
                    edit.clear();
                    break;
            }
        }
    };

} // MainActivity