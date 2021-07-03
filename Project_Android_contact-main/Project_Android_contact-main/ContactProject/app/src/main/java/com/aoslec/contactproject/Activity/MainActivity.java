package com.aoslec.contactproject.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aoslec.contactproject.Adapter.MainFragmentAdapter;
import com.aoslec.contactproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 pager2;
    MainFragmentAdapter adapter;
    FloatingActionButton newProfile, call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("주소록");

        //상단 네비
        tabLayout = findViewById(R.id.tabLayout);

        //액션버튼
        newProfile =findViewById(R.id.newProfile);
        call = findViewById(R.id.call);

        newProfile.setOnClickListener(onClickListener);
        call.setOnClickListener(onClickListener);

        //페이지
        pager2 = findViewById(R.id.viewPager2);

        //페이지연결
        FragmentManager fm = getSupportFragmentManager();
        adapter = new MainFragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }//c

    //메뉴설정
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.main_menu, menu);
        return true;
    }

    //메뉴 선택시

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.maker:
                Toast.makeText(MainActivity.this,"하이",Toast.LENGTH_SHORT).show();

                final LinearLayout linear = (LinearLayout) View.inflate(MainActivity.this, R.layout.dialog_maker, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("만든이")
                        .setView(linear)
                        .setPositiveButton("감사합니다", null)
                        .show();
        }

        return true;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.call:
                    //startActivity(new Intent(Intent.ACTION_DIAL));
                    startActivity(new Intent(Intent.ACTION_DIAL));
                    break;
                case R.id.newProfile:
                    startActivity(new Intent(MainActivity.this, ProfileRegisterActivity.class));
                    break;

            }

        }
    }; //onClickListener

    public void setActionBarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

}//m