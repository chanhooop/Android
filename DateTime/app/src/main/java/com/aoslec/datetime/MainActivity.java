package com.aoslec.datetime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvhour, tvMinute;

    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간예약");

        // 버튼
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        // 크로노미터
        chronometer = findViewById(R.id.chronometer1);
        //라디오 버튼 2개
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        // Framlayou 의 2개 위젯
        tPicker = findViewById(R.id.timePicker1);
        calView = findViewById(R.id.calenderView1);

        //TextView중에서 년, 월,일, 시, 분
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvhour = findViewById(R.id.tvTime);
        tvMinute = findViewById(R.id.tvMinute);

        // 처음에는 2개를 안보이게 설정
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        // 타이머 설정
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });


        // 캘린더 선택
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });

        // 예약완료 번튼 눌렀을 때
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                tvhour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });

    } // onCreate

} // MainActivity






