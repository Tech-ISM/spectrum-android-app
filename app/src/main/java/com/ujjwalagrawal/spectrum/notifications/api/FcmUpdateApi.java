package com.ujjwalagrawal.spectrum.notifications.api;


import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.notifications.data.FcmUpdateData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FcmUpdateApi {

    @FormUrlEncoded
    @POST(Urls.SUB_URL_UPDATE_FCM)
    Call<FcmUpdateData> updateFcm(
            @Field("fcm") String fcm, @Field("access_token") String access_token);
}
