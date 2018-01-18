package com.ujjwalagrawal.spectrum;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 25-10-2017.
 */

public interface ApiNotificationsService {
    //base interface to post on the server to query
    //TODO: Enter the exact query path
    @POST("/notifications")
    @FormUrlEncoded
    Call<com.ujjwalagrawal.spectrum.NotificationsData> postAccessToken(@Field("access_token") String access_token );

}
