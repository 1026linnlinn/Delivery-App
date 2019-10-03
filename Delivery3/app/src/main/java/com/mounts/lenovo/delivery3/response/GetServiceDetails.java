package com.mounts.lenovo.delivery3.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetServiceDetails {
    @SerializedName("id")
    public int getServiceId;

    @SerializedName("name")
    public String getServiceName;

    @SerializedName("logo")
    public String serviceLogo;

    @SerializedName("address")
    public String getServiceAddress;

    @SerializedName("lat")
    public String getServiceLat;

    @SerializedName("lon")
    public String getServiceLon;

    @SerializedName("category")
    public String getServiceCategory;

    @SerializedName("featured")
    public String getServiceFeatured;

    @SerializedName("photos")
    public List<ServicePhoto> getServicePhotos;

    @SerializedName("products")
    public List<ServiceProducts> getServiceProducts;
}
