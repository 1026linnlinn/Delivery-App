package com.mounts.lenovo.delivery3.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ServiceProducts {

    @SerializedName("id")
    public int serviceProductsId;

    @SerializedName("name")
    public String serviceProductsName;

    @SerializedName("price")
    public int serviceProductsPrice;

    @SerializedName("adds_on_service_id")
    public int serviceProductsAddsOnServiceId;

    @SerializedName("created_at")
    public Date serviceProductsCreated_at;

    @SerializedName("updated_at")
    public Date serviceProductsUpdated_at;

    @SerializedName("photo")
    public String serviceProductsPhoto;

}
