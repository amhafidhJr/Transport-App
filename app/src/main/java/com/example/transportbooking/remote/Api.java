package com.example.transportbooking.remote;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("/insert.php")
    public void insertUser(
            @Field("fullname") String fullname,
            @Field("address") String address,
            @Field("email") String email,
            @Field("phoneNo") String phoneNo,
            @Field("seats") String seats,
            Callback<Response> callback);
}
