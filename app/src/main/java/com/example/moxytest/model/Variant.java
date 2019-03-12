package com.example.moxytest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("text")
    @Expose
    private String text;

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

}
