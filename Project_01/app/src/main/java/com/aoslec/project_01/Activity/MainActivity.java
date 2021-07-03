package com.aoslec.project_01.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.aoslec.project_01.Adapter.RecyclerAdapter;
import com.aoslec.project_01.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    CalendarView cld_main;
    TextView tv_year, tv_month, tv_date;
    Button btn_add_main;
    EditText edtIp;

    int selectYear, selectMonth, selectDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("ggg","activity main");


        addListener();


        cld_main.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDate = dayOfMonth;

                tv_year.setText(Integer.toString(selectYear));
                tv_month.setText(Integer.toString(selectMonth));
                tv_date.setText(Integer.toString(selectDate));


            }
        });





    } // onCreate

    private void addListener() {
        edtIp = findViewById(R.id.edtIp);
        cld_main = findViewById(R.id.cld_main);
        tv_year = findViewById(R.id.tv_year);
        tv_month = findViewById(R.id.tv_month);
        tv_date = findViewById(R.id.tv_date);
        btn_add_main = findViewById(R.id.btn_add_main);

        btn_add_main.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tempIp = edtIp.getText().toString();

            switch (v.getId()){
                case R.id.btn_add_main:
                    Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                    intent.putExtra("year",tv_year.getText().toString());
                    intent.putExtra("month",tv_month.getText().toString());
                    intent.putExtra("date",tv_date.getText().toString());
                    intent.putExtra("macIP",tempIp);
                    startActivity(intent); // 액티비티 이동
                    break;
            }
        }
    };

} //MainActivity