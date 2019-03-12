package com.example.moxytest;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moxytest.model.Variant;

import java.util.List;

public class Dialogs {

    public static void GetType1(Context ctx, String url, String text){
        LayoutInflater li = LayoutInflater.from(ctx);
        AlertDialog.Builder b = new AlertDialog.Builder(ctx);
        View promptsView2 = li.inflate(R.layout.row1, null);
        ImageView imageView = promptsView2.findViewById(R.id.imageView);
        TextView tv = promptsView2.findViewById(R.id.textView2);
        tv.setText(text);
        Glide.with(ctx).load(url).into(imageView);
        b.setView(promptsView2);
        b.setPositiveButton("ОК", null);
        final AlertDialog a = b.create();
        a.show();
        Button bq = a.getButton(DialogInterface.BUTTON_POSITIVE);
        bq.setTextColor(ctx.getResources().getColor(R.color.colorPrimaryDark));
    }

    public static void GetType2(Context ctx, final List<Variant> list, final DialogCallback callback){
        final LayoutInflater li = LayoutInflater.from(ctx);
        AlertDialog.Builder b = new AlertDialog.Builder(ctx);
        View promptsView2 = li.inflate(R.layout.row2, null);
        RecyclerView rv = promptsView2.findViewById(R.id.rv2);
        final Adapter2 adapter = new Adapter2(list);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(ctx));
        rv.setAdapter(adapter);
        b.setView(promptsView2);
        b.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        final AlertDialog a = b.create();
        a.show();
        rv.addOnItemTouchListener(new RecycleTouchListener(ctx, new RecycleTouchListener.RecycleListener() {
            @Override
            public void onClick(View view, int position) {
                switch (position) {
                    default:
                        callback.getMessage(list.get(position).getText());
                        a.dismiss();
                        break;
                }
            }
        }));
        Button bq = a.getButton(DialogInterface.BUTTON_POSITIVE);
        bq.setTextColor(ctx.getResources().getColor(R.color.colorPrimaryDark));
    }

    public static void GetType3(Context ctx, String text){
        LayoutInflater li = LayoutInflater.from(ctx);
        AlertDialog.Builder b = new AlertDialog.Builder(ctx);
        View promptsView2 = li.inflate(R.layout.row, null);
        TextView tv = promptsView2.findViewById(R.id.textView);
        tv.setText(text);
        b.setView(promptsView2);
        b.setPositiveButton("ОК", null);
        final AlertDialog a = b.create();
        a.show();
        Button bq = a.getButton(DialogInterface.BUTTON_POSITIVE);
        bq.setTextColor(ctx.getResources().getColor(R.color.colorPrimaryDark));
    }
}
