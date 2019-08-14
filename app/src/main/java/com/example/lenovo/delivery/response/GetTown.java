package com.example.lenovo.delivery.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTown {
    @SerializedName("towns")
    public List<ReceiverCity> cities;
}
