package com.example.lenovo.delivery.response;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("isSuccess")
    public Boolean isSuccess;

    @SerializedName("user_id")
    public int id;

    @SerializedName("sessionId")
    public String sessionId;

    @SerializedName("errors")
    public String errors;
}
