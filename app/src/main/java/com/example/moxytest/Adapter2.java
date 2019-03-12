package com.example.moxytest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moxytest.model.Variant;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.MyViewHolder>  {
    private List<Variant> entriesList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tv, tvID;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
            tvID = itemView.findViewById(R.id.textView3);
        }
    }
    public Adapter2 (List<Variant> myList){
        entriesList = myList;
    }

    @Override
    public Adapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new Adapter2.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Adapter2.MyViewHolder holder, int position) {
        holder.tv.setText(entriesList.get(position).getText());
        holder.tvID.setVisibility(View.VISIBLE);
        holder.tvID.setText(String.valueOf(entriesList.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return entriesList.size();
    }

}
