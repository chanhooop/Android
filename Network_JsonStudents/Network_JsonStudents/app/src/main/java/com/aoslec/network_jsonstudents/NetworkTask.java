package com.aoslec.network_jsonstudents;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<JsonStudents> students;

    public NetworkTask(Context context, String mAddr) {
        this.context = context;
        this.mAddr = mAddr;
        this.students = new ArrayList<JsonStudents>();
    }

    @Override
    protected Object doInBackground(Integer... integers) {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000); //10초 동안 연결 시도하다가 실패시 에러

            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true) {
                    String strline = bufferedReader.readLine();
                    if(strline == null) break;
                    stringBuffer.append(strline + "\n");
                }
                parser(stringBuffer.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (inputStream != null) inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return students;
    }

    private void parser(String str) {
        try{
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));
            students.clear(); //기존에 쌓일 수 있는 데이터를 삭제함

            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String name = jsonObject1.getString("name");
                Log.v("Status", "name : "+name);
                String dept = jsonObject1.getString("dept");
                Log.v("Status", "dept : "+dept);
                String code = jsonObject1.getString("code");
                Log.v("Status", "code : "+code);
                String phone = jsonObject1.getString("phone");
                Log.v("Status", "phone : "+phone);


                JsonStudents student = new JsonStudents(name,dept,phone,code);
                students.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
