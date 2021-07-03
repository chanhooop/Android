package com.aoslec.project_01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aoslec.project_01.Adapter.listAdapter;
import com.aoslec.project_01.Bean.list;
import com.aoslec.project_01.NetworkTask.NetworkTask;
import com.aoslec.project_01.R;

import java.util.ArrayList;

public class Select_main_list_Activity extends AppCompatActivity {

    String urlAddr = null;
    ArrayList<list>lists;
    listAdapter adapter;
    ListView listView;
    String macIP,today;
    TextView tv_today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_card_view);





        tv_today = findViewById(R.id.tv_date_insert);
        today = tv_today.getText().toString();
        listView = findViewById(R.id.list);

        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");

        urlAddr = "http://" + macIP + ":8080/test/diarylistselect.jsp?today=" + today;

    }

    @Override
    //!!!!!!  onResume에서 불러온다  !!!!!!
    protected void onResume() {
        super.onResume();
        connectGetData();
    }

    private void connectGetData(){
        try {
            NetworkTask networkTask = new NetworkTask(Select_main_list_Activity.this, urlAddr, "select");
            Object obj = networkTask.execute().get();
            lists = (ArrayList<list>) obj;

            adapter = new listAdapter(Select_main_list_Activity.this, R.layout.item_card_view, lists);
            listView.setAdapter(adapter);
//            listView.setOnItemClickListener(onItemClickListener);
//            listView.setOnItemLongClickListener(onItemLongClickListener);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
//        Intent intent = null;
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            intent = new Intent(Select_main_list_Activity.this, UpdateActivity.class);
//            intent.putExtra("code", members.get(position).getCode());
//            intent.putExtra("name", members.get(position).getName());
//            intent.putExtra("dept", members.get(position).getDept());
//            intent.putExtra("phone", members.get(position).getPhone());
//            intent.putExtra("macIP", macIP);
//            startActivity(intent);
//
//        }
//    };
//
//    AdapterView.OnItemLongClickListener onItemLongClickListener =new AdapterView.OnItemLongClickListener() {
//        Intent intent = null;
//        @Override
//        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//            intent = new Intent(SelectAllActivity.this,DeleteActivity.class);
//            intent.putExtra("code", members.get(position).getCode());
//            intent.putExtra("name", members.get(position).getName());
//            intent.putExtra("dept", members.get(position).getDept());
//            intent.putExtra("phone", members.get(position).getPhone());
//            intent.putExtra("macIP", macIP);
//            startActivity(intent);
//
//            return false;
//        }
//    };

}
