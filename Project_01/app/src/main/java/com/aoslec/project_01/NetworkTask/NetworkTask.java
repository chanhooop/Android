package com.aoslec.project_01.NetworkTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.aoslec.project_01.Bean.diary;
import com.aoslec.project_01.Bean.list;

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
    ArrayList<diary> diaries;
    ArrayList<list> list;

    String where = null;

    public NetworkTask(Context context, String mAddr, String where) {
        this.context = context;
        this.mAddr = mAddr;
        this.diaries = new ArrayList<diary>();
        this.list = new ArrayList<list>();
        this.where = where;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialog");
        progressDialog.setMessage("Get....");
        progressDialog.show();

    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        progressDialog.dismiss();
    }

    @Override
    protected Object doInBackground(Integer... integers) {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String result = null;

        //----------------------------기본 양식----------------
        try{
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);  //10초
            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true){
                    String strline = bufferedReader.readLine();
                    if(strline == null) break;
                    stringBuffer.append(strline + "\n");
                }  //----------------------------------------------------------------

                if (where.equals("select")){
                    parserList(stringBuffer.toString());
                }else {
                    result = parserAction(stringBuffer.toString());
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null) bufferedReader.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (inputStream != null) inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            if (where.equals("select")){
                return list;
            }else {
                return result;
            }
        }
    }

    private String parserAction(String str){
        String returnValue = null;
        try {
            JSONObject jsonObject = new JSONObject(str);
            returnValue = jsonObject.getString("result");
        }catch (Exception e){
            e.printStackTrace();
        }

        return  returnValue;
    }

    private void parserList(String str) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("diary_info"));
            list.clear();

            for (int i = 0; i<jsonArray.length();i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String now = jsonObject1.getString("now");
                String score = jsonObject1.getString("score");
                String level = jsonObject1.getString("level");

                list l = new list(now, score, level);
                list.add(l);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

