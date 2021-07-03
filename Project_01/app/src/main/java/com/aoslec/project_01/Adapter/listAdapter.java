package com.aoslec.project_01.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aoslec.project_01.Bean.list;
import com.aoslec.project_01.R;

import java.util.ArrayList;

public class listAdapter extends BaseAdapter {

    private Context mContext = null;
    private  int layout = 0;     // 리스트뷰아나에 있는 레이아웃
    private ArrayList<list> data = null;
    private LayoutInflater inflater = null;

    public listAdapter(Context mContext, int layout, ArrayList<list> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getToday();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(this.layout,parent,false);
        TextView card_time = convertView.findViewById(R.id.card_time);
        TextView card_score = convertView.findViewById(R.id.card_score);
        TextView card_level = convertView.findViewById(R.id.card_level);

        card_time.setText("성명 : "  + data.get(position).getNow());
        card_score.setText("성명 : "  + data.get(position).getScore());
        card_level.setText("성명 : "  + data.get(position).getLevel());
        return convertView;
    }
}
