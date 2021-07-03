package com.aoslec.project_01.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aoslec.project_01.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView card_image;
        public TextView card_time, card_score, card_level;

        public ViewHolder(View itemView) {
            super(itemView);
            card_image = itemView.findViewById(R.id.card_image);
            card_time = itemView.findViewById(R.id.card_time);
            card_score = itemView.findViewById(R.id.card_score);
            card_level = itemView.findViewById(R.id.card_level);
        }


    }
}
