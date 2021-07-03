package com.aoslec.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb_01);
        cb2 = findViewById(R.id.cb_02);
        cb3 = findViewById(R.id.cb_03);
        cb4 = findViewById(R.id.cb_04);

        cb1.setOnCheckedChangeListener(checkChangListener);
        cb2.setOnCheckedChangeListener(checkChangListener);
        cb3.setOnCheckedChangeListener(checkChangListener);
        cb4.setOnCheckedChangeListener(checkChangListener);

    } //onCreate
                        // 이부분 두개 뜨는데 radio그룹은 radio버튼 만들때 쓰는것
                        // CompoundButton을 선택해줘야 체크박스 생성
        CompoundButton.OnCheckedChangeListener checkChangListener = new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                String str = "";


                                switch (buttonView.getId()){
                                    case R.id.cb_01:
                                        if(isChecked == true){
                                            str += "운동";
                                            break;
                                        }
                                    case R.id.cb_02:
                                        if(isChecked == true){
                                            str += "영화";
                                            break;
                                        }
                                    case R.id.cb_03:
                                        if(isChecked == true){
                                            str += "독서";
                                            break;
                                        }
                                    case R.id.cb_04:
                                        if(isChecked == true){
                                            str += "산책";
                                            break;
                                        }
                                }

                                Toast.makeText(MainActivity.this,str + " is checked.", Toast.LENGTH_SHORT).show();

                            }
                        };


}//MainActivity