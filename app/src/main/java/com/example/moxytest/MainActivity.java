package com.example.moxytest;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.moxytest.model.Data;
import com.example.moxytest.model.DataEntry;
import com.example.moxytest.mvp.HWPresenter;
import com.example.moxytest.mvp.HWView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MvpAppCompatActivity implements HWView {
    @InjectPresenter
    HWPresenter hwPresenter;

    RecyclerView recyclerView;
    Adapter adapter;
    List<String> viewsList = new ArrayList<>();
    List<DataEntry> dataEntries;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        adapter = new Adapter(viewsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new RecycleTouchListener(this, new RecycleTouchListener.RecycleListener() {
            @Override
            public void onClick(View view, final int position) {
                switch (position){
                    default:
                        category = viewsList.get(position);
                        for(DataEntry dataEntry : dataEntries){
                            if(dataEntry.getName().equals(category)){
                                displayInfo(dataEntry.getData());
                            }
                        }
                        break;
                }
            }
        }));
    }

    private void displayInfo(Data data) {
        if(data.getUrl()!=null){
            Dialogs.GetType1(this,data.getUrl(),data.getText());
        }else if(data.getVariants()!=null){
            Dialogs.GetType2(this, data.getVariants(), new DialogCallback() {
                @Override
                public void getMessage(String message) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Dialogs.GetType3(this, data.getText());

    }

    @Override
    public void getData(List<DataEntry> list) {
        dataEntries = list;
    }

    @Override
    public void getViews(List<String> viewList) {
        viewsList = viewList;
        adapter.update(viewsList);
    }
}
