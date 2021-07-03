package com.aoslec.androidproject.Fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.aoslec.androidproject.Activity.AdminSelectAd;
import com.aoslec.androidproject.Adapter.Admin_RequestAdapter;
import com.aoslec.androidproject.Bean.Ad_requestBean;

import com.aoslec.androidproject.NetworkTask.NetworkTaskAdmin;
import com.aoslec.androidproject.R;
import com.aoslec.androidproject.SaveSharedPreferences.SaveSharedPreferences;

import java.io.File;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class Admin_RequestFragment extends Fragment {


    String urlAddr = null;
    ArrayList<Ad_requestBean> requestBeans;
    Admin_RequestAdapter adapter;
    ListView listView1;
    ImageView img;

    //이미지 업로드에 쓰일 것
    String devicePath = Environment.getDataDirectory().getAbsolutePath() + "/data/com.aoslec.androidproject/";

    private final int REQ_CODE_SELECT_IMAGE = 300; // Gallery Return Code
    private String img_path = null; // 최종 file name
    private String f_ext = null;    // 최종 file extension
    File tempSelectFile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //          사용자에게 사진(Media) 사용 권한 받기
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);


        Log.v("ggg", "프레그먼트 시작");

        View view = inflater.inflate(R.layout.fragment_admin__request, container, false);

        listView1 = view.findViewById(R.id.request_listview1);

        String pcIP = SaveSharedPreferences.getUrl(getActivity());
        urlAddr = pcIP + "adRequestSelect.jsp";
        Log.v("ggg","유알엘 : " + urlAddr);


        return view;
    }

    @Override
    //!!!!!!  onResume에서 불러온다  !!!!!!
    public void onResume() {
        super.onResume();
        connectGetData();
        Log.v("ggg","onResume connectGetData 연결");
    }

    private void connectGetData(){
        try {
            NetworkTaskAdmin networkTask = new NetworkTaskAdmin(getActivity(), urlAddr, "selectRequest");
            Object obj = networkTask.execute().get();
            requestBeans = (ArrayList<Ad_requestBean>) obj;

            adapter = new Admin_RequestAdapter(getActivity(), R.layout.fragment_admin_request_simpleview, requestBeans);
            listView1.setAdapter(adapter);
            listView1.setOnItemClickListener(onItemClickListener);
//            listView1.setOnItemLongClickListener(onItemLongClickListener);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        Intent intent = null;
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(getContext(), AdminSelectAd.class);
            intent.putExtra("title", requestBeans.get(position).getTitle());
            intent.putExtra("url", requestBeans.get(position).getUrl());
            intent.putExtra("price", requestBeans.get(position).getPrice());
            intent.putExtra("email", requestBeans.get(position).getEmail());
            intent.putExtra("image",requestBeans.get(position).getImage());
            intent.putExtra("adid",requestBeans.get(position).getAdid());

            startActivity(intent);
        }
    };
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