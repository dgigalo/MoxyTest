package com.example.moxytest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataEntry {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getName() {
        return name;
    }

    public Data getData() {
        return data;
    }

}
