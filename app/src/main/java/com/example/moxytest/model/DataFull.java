package com.example.moxytest.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class DataFull {
    @SerializedName("data")
    @Expose
    private List<DataEntry> data = null;
    @SerializedName("view")
    @Expose
    private List<String> view = null;

    public List<DataEntry> getData() {
        return data;
    }

    public List<String> getView() {
        return view;
    }
}
