package com.aoslec.networkjson_studentjason;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MemberAdapter extends BaseAdapter {
    private Context mContext = null;
    private  int layout = 0;
    private ArrayList<JasonMember> data = null;
    private LayoutInflater inflater = null;

    public MemberAdapter(Context mContext, int layout, ArrayList<JasonMember> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(this.layout, parent, false);
        TextView tv_code = convertView.findViewById(R.id.tv_code);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_dept = convertView.findViewById(R.id.tv_dept);
        TextView tv_phone = convertView.findViewById(R.id.tv_phon);

        tv_code.setText("code : " + data.get(position).getCode());
        tv_name.setText("name : " + data.get(position).getName());
        tv_dept.setText("dept : " + data.get(position).getDept());
        tv_phone.setText("phone : " + data.get(position).getPhone());


        if((position % 2) == 1 ){
            convertView.setBackgroundColor(0x5000ff00);
        }else {
            convertView.setBackgroundColor(0x500000ff);
        }

        return convertView;
    }
}

