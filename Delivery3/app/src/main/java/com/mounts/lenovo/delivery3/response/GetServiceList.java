package com.mounts.lenovo.delivery3.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetServiceList{

    @SerializedName("data")
    public List<CategoryData> categoryData;
}
