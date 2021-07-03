package org.techtown.final_hw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity {

    Button btnBack,btnSave;
    CalendarView calView;
    EditText edtMeal;
    TextView tvYear, tvMonth, tvDay;
    int selectYear, selectMonth, selectDay;
    String password;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("나의 하루 식사");

        btnBack = (Button)findViewById(R.id.btnBack);
        btnSave = (Button)findViewById(R.id.btnSave);
        calView = (CalendarView) findViewById(R.id.calView);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        edtMeal = (EditText)findViewById(R.id.edtMeal);

        Intent intent = new Intent(this.getIntent());
        password = intent.getStringExtra("input");

        if(password.toString().equals(""))
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "패스워드가 다릅니다. 다시 로그인하세요.", Toast.LENGTH_SHORT).show();
            finish();
        }

        fileName = Integer.toString(selectYear) + "_" + Integer.toString(selectMonth+1)
                + "_" + Integer.toString(selectDay) + ".txt";
        String str = readDiary(fileName);
        edtMeal.setText(str);

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectYear =  year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                fileName = Integer.toString(year) + "_"
                        + Integer.toString(month + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);
                edtMeal.setText(str);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName,
                            Context.MODE_PRIVATE);
                    String str = edtMeal.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),
                            fileName + " 이  저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"로그아웃 되었습니다.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btnSave.setText("수정 하기");
        } catch (IOException e) {
            edtMeal.setHint("여기에 입력하세요.");
            btnSave.setText("새로 저장");
        }
        return diaryStr;
    }
}
