package com.mounts.lenovo.delivery3.response;

import com.google.gson.annotations.SerializedName;

public class AddOrderInfo {
    @SerializedName("isSuccess")
    public Boolean isSuccess;

    @SerializedName("cost")
    public int id;

    @SerializedName("duration")
    public String duration;
}
