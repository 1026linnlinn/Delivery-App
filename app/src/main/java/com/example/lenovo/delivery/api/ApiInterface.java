package com.example.lenovo.delivery.api;

import android.widget.EditText;

import com.example.lenovo.delivery.response.AddOrderInfo;
import com.example.lenovo.delivery.response.GetTown;
import com.example.lenovo.delivery.response.LoginResponse;
import com.example.lenovo.delivery.response.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("/api/user/login")
    Call<LoginResponse> login(@Field("phone_number") String phoneNumber,
                              @Field("password") String password);

    @FormUrlEncoded
    @POST("/api/user/register")
    Call<RegisterResponse> register(@Field("name") String name,
                                    @Field("phone_number") String phoneNumber,
                                    @Field("password") String password,
                                    @Field("password_confirmation") String confirmPassword,
                                    @Field("email") String useremail);

    @FormUrlEncoded
    @POST("/api/user/order/create")
    Call<AddOrderInfo> fullOrderInformation(@Field("user_city") String usercity,
                                            @Field("name") String ordername,
                                            @Field("weight") String estimatedweight,
                                            @Field("receiver_name") String edtname,
                                            @Field("receiver_phone_number") String edtphone,
                                            @Field("receiver_address") String edtaddress,
                                            @Field("receiver_city") String city,
                                            @Field("order_prepaid") boolean orderprepaidcheckbox,
                                            @Field("order_postpaid") boolean orderpostpaidcheckbox,
                                            @Field("sessionId") String sessionId);

    @FormUrlEncoded
    @POST("/api/user/order/create")
    Call<AddOrderInfo> orderInformation(@Field("name") String ordername,
                                        @Field("weight") String estimatedweight,
                                        @Field("receiver_name") String edtname,
                                        @Field("receiver_phone_number") String edtphone,
                                        @Field("receiver_address") String edtaddress,
                                        @Field("receiver_city") String spinnercity,
                                        @Field("order_prepaid") boolean orderprepaidcheckbox,
                                        @Field("order_postpaid") boolean orderpostpaidcheckbox);

    @FormUrlEncoded
    @POST("/api/user/order/create")
    Call<AddOrderInfo> orderInformation(@Field("name") String ordername,
                                        @Field("weight") String estimatedweight,
                                        @Field("receiver_name") String edtname,
                                        @Field("receiver_phone_number") String edtphone,
                                        @Field("receiver_address") String edtaddress,
                                        @Field("receiver_city") String spinnercity);

    @GET("/api/user/offices/get_towns")
    Call<GetTown> getOfficeTown();

}
