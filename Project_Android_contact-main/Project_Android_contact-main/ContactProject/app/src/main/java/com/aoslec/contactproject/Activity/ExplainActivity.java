package com.aoslec.contactproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoslec.contactproject.Adapter.ExplainAdapter;
import com.aoslec.contactproject.Bean.Explain;
import com.aoslec.contactproject.R;

import java.util.ArrayList;
import java.util.List;

public class ExplainActivity extends AppCompatActivity {

    LinearLayout dotsLayout;
    ExplainAdapter adapter;
    List<Explain> data;
    Button getStarted;
    TextView skip;
    ViewPager2 viewPager2;
    ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //점 표시
        dotsLayout = findViewById(R.id.Explain_Dots_layout);

        //버튼
        getStarted = findViewById(R.id.Explain_StartBtn);

        //skip

        skip = findViewById(R.id.Explain_Skip);

        //ViewPager2
        viewPager2 = findViewById(R.id.Explain_ViewPager2);

        //버튼과 skip클릭시
        skip.setOnClickListener(main);
        getStarted.setOnClickListener(main);


        //데이타 넣기
        data = new ArrayList<>();
        data.add(new Explain(R.drawable.ex_contact));
        data.add(new Explain(R.drawable.ex_favorite));
        data.add(new Explain(R.drawable.ex_group));

        adapter = new ExplainAdapter(data);
        viewPager2.setAdapter(adapter);

        dots =new ImageView[3];
        createDots();
        selectedDots(0);


        //버튼과 skip 보여줌.
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                selectedDots(position);

                if (position == 0 || position == 1){
                    skip.setVisibility(View.VISIBLE);
                }else {
                    skip.setVisibility(View.INVISIBLE);
                }
                if(position == 2){
                    getStarted.setVisibility(View.VISIBLE);
                    getStarted.setEnabled(true);
                }else {
                    getStarted.setVisibility(View.INVISIBLE);
                    getStarted.setEnabled(false);
                }
            }
        });


    }//c

    //선택된 페이지의 점변화
    private void selectedDots(int position) {
        for(int i=0; i<dots.length; i++){
            if(i==position){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.selected_dot));
            }else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.unselected_dot));
            }
        }

    }

    //점 갯수 생성.
    private void createDots() {
        for(int i=0; i<dots.length; i++){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(6,0,6,0);

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.unselected_dot));
            dots[i].setLayoutParams(params);
            dotsLayout.addView(dots[i]);
        }

    }

    //버튼과 skip클릭시 메인으로 가는 메소드
    View.OnClickListener main =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ExplainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };
}