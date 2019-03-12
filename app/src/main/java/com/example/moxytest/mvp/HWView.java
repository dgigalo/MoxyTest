package com.example.moxytest.mvp;

import com.arellomobile.mvp.MvpView;
import com.example.moxytest.model.DataEntry;

import java.util.List;

public interface HWView extends MvpView {
    void getData(List<DataEntry> list);
    void getViews(List<String> viewList);
}
