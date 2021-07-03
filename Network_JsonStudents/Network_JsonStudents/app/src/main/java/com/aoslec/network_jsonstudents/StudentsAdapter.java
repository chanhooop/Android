package com.aoslec.network_jsonstudents;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {





    private Context mContext = null;
    private int layout = 0;
    private ArrayList<JsonStudents> data = null;
    private LayoutInflater inflater = null;


    public StudentsAdapter(Context mContext, int layout, ArrayList<JsonStudents> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    //----------------------------------------------------
    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_dept;
        TextView tv_code;
        TextView tv_phone;



        public ViewHolder(View itemView) {
            super(itemView);
            Log.v("Message","ViewHolder/ViewHolder");
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_dept = itemView.findViewById(R.id.tv_dept);
            tv_code = itemView.findViewById(R.id.tv_code);
            tv_phone = itemView.findViewById(R.id.tv_phone);

        }
    }
    //----------------------------------------------------

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentsAdapter.ViewHolder holder, int position) {

        holder.tv_name.setText(data.get(position).getName());
        holder.tv_code.setText(data.get(position).getCode());
        holder.tv_dept.setText(data.get(position).getDept());
        holder.tv_phone.setText(data.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        Log.v("MessageHi",data.size()+" + StudentsAdapter/getItemCount()");
        return data.size();
    }



}
