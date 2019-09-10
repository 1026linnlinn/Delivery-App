package com.mounts.lenovo.delivery3.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mounts.lenovo.delivery3.service.Token;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitService {


    //    public static final String BASE_URL = "http://192.168.100.173:8000";
//
//    public Retrofit getService() {
//        Retrofit build = new Retrofit
//                .Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        return build;
//    }
    private String token= Token.getToken();
    public static final String BASE_URL = "http://192.168.100.199:8000";

    public Retrofit getService() {


        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request originalRequest = chain.request();

                        Request newRequest = originalRequest.newBuilder()
                                .header("Authorization", token)
                                .build();
                        return chain.proceed(newRequest);
                    }
                });

        OkHttpClient client = clientBuilder.build();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit service = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        return service;
//TODO: ya ma ya check yan
    }
}
