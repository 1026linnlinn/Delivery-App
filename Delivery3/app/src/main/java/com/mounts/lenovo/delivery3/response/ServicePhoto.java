package com.mounts.lenovo.delivery3.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ServicePhoto {

    @SerializedName("id")
    public int servicePhotoId;

    @SerializedName("url")
    public String servicePhotoUrl;

    @SerializedName("adds_on_service_id")
    public int servicePhotoAddsOnServiceId;

    @SerializedName("created_at")
    public Date servicePhotoCreatedAt;

    @SerializedName("updated_at")
    public Date servicePhotoUpdatedAt;

}
