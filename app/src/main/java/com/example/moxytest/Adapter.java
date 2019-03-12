package com.example.moxytest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>  {
    private List<String> entriesList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
        }
    }
    public Adapter (List<String> myList){
        entriesList = myList;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {
            holder.tv.setText(entriesList.get(position));
    }

    @Override
    public int getItemCount() {
        return entriesList.size();
    }

    public void update(List<String> myList){
        entriesList = myList;
        notifyDataSetChanged();
    }
}
