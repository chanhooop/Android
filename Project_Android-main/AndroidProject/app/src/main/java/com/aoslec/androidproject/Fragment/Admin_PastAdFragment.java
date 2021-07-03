package com.aoslec.androidproject.Fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aoslec.androidproject.Activity.AdminApproveSelectAd;
import com.aoslec.androidproject.Adapter.Admin_ApproveAdapter;
import com.aoslec.androidproject.Adapter.Admin_PastAdapter;
import com.aoslec.androidproject.Bean.Ad_requestBean;
import com.aoslec.androidproject.NetworkTask.NetworkTaskAdmin;
import com.aoslec.androidproject.R;
import com.aoslec.androidproject.SaveSharedPreferences.SaveSharedPreferences;

import java.io.File;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class Admin_PastAdFragment extends Fragment {

    String urlAddr = null;
    ArrayList<Ad_requestBean> requestBeans;
    Admin_PastAdapter adapter;
    ListView listView1;
    CardView cardView;

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

        View view = inflater.inflate(R.layout.fragment_admin__past_ad, container, false);

        listView1 = view.findViewById(R.id.pastad_listView);
        cardView = view.findViewById(R.id.past_card_view);

        String pcIP = SaveSharedPreferences.getUrl(getActivity());

        urlAddr = pcIP + "adPastAdSelect.jsp";
        Log.v("ggg","유알엘 체크 : " + urlAddr);


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
            NetworkTaskAdmin networkTask = new NetworkTaskAdmin(getActivity(), urlAddr, "selectApprove");
            Object obj = networkTask.execute().get();
            Log.v("ggg","오브젝트:" + obj);
            requestBeans = (ArrayList<Ad_requestBean>) obj;

            adapter = new Admin_PastAdapter(getActivity(),R.layout.fragment_admin_pastad_cardview, requestBeans);
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
            intent = new Intent(getContext(), AdminApproveSelectAd.class);
            intent.putExtra("title", requestBeans.get(position).getTitle());
            intent.putExtra("url", requestBeans.get(position).getUrl());
            intent.putExtra("price", requestBeans.get(position).getPrice());
            intent.putExtra("email", requestBeans.get(position).getEmail());
            intent.putExtra("image",requestBeans.get(position).getImage());
            intent.putExtra("adid",requestBeans.get(position).getAdid());
            Log.v("ggg", "프레그먼트 이미지 경로 확인 : " + requestBeans.get(position).getImage());
            startActivity(intent);

        }
    };

}