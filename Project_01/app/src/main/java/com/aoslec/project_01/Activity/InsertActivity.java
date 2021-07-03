package com.aoslec.project_01.Activity;


import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aoslec.project_01.NetworkTask.NetworkTask;
import com.aoslec.project_01.R;

import java.util.Calendar;
import java.util.Locale;

public class InsertActivity extends AppCompatActivity {

    String urlAddr = null;

    Button btn_insert;
    TextView tv_date_insert, tv_result_time_insert;
    EditText et_memo;

    String syear, smonth , sdate, macIP, today, now, score, level, memo;
    int tHour, tMinute, numid, levelid; // 선택된 시간

    RadioGroup radio_num, radio_level;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.v("ggg", "onCreate insert");
        setContentView(R.layout.activity_insert);

        tv_date_insert = findViewById(R.id.tv_date_insert);
        tv_result_time_insert = findViewById(R.id.tv_result_time_insert);

        Intent intent = getIntent();
        syear = intent.getStringExtra("year");
        smonth = intent.getStringExtra("month");
        sdate = intent.getStringExtra("date");
        today = syear + "년 " + smonth + "월 " + sdate + "일";
        tv_date_insert.setText(today);

        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/diaryInsertReturn.jsp?";

        btn_insert = findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(onClickListener);

        radio_num = findViewById(R.id.radio_num);
        radio_level = findViewById(R.id.radio_level);

    }//onCreate

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            numid = radio_num.getCheckedRadioButtonId();
            RadioButton rb_num = findViewById(numid);
            score = rb_num.getText().toString();

            levelid = radio_level.getCheckedRadioButtonId();
            RadioButton rb_level = findViewById(levelid);
            level = rb_level.getText().toString();

            et_memo = findViewById(R.id.et_memo);
            memo = et_memo.getText().toString();

            urlAddr = urlAddr + "today=" + today + "&now=" + now + "&score=" + score + "&level=" + level + "&memo=" + memo;
            Log.v("ggg","urlAddr : " + urlAddr);

            String result = connectInsertData();
            if (result.equals("1")){
                Toast.makeText(InsertActivity.this, today+"의 기록이 입력되었습니다.", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(InsertActivity.this, "입력이 실패하였습니다.", Toast.LENGTH_SHORT).show();
            }
            finish();

        }
    };  // onClickListener

    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute)
            {
            tHour = selectedHour;
            tMinute = selectedMinute;
            tv_result_time_insert.setText(String.format(Locale.getDefault(),"%02d:%02d",tHour,tMinute));

            now = Integer.toString(tHour) + "시 " + Integer.toString(tMinute) +"분";
            Log.v("ggg", "now : " + now);
            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(InsertActivity.this, style, onTimeSetListener,tHour,tMinute,true);
        timePickerDialog.setTitle("시간을 선택하세요");
        timePickerDialog.show();

    }

    private  String connectInsertData(){
        String result = null;
        try {
            NetworkTask networkTask = new NetworkTask(InsertActivity.this, urlAddr,"insert");
            Object obj = networkTask.execute().get();
            result = (String)obj;

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

} //InsertActivity
