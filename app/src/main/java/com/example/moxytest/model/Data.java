package com.example.moxytest.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("selectedId")
    @Expose
    private Integer selectedId;
    @SerializedName("variants")
    @Expose
    private List<Variant> variants = null;

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public List<Variant> getVariants() {
        return variants;
    }
}
