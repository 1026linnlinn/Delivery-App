package com.mounts.lenovo.delivery3.response;

import com.google.gson.annotations.SerializedName;

import java.lang.ref.SoftReference;
import java.util.List;

public class Categories {
    @SerializedName("id")
    public int cateId;

    @SerializedName("name")
    public String cateName;

    @SerializedName("adds_on_services")
    public List<String> adds_on_services;

    public String logo;
}
