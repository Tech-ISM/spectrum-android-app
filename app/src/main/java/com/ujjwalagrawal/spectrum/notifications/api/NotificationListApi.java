package com.ujjwalagrawal.spectrum.notifications.api;


import com.ujjwalagrawal.spectrum.notifications.data.NotificationData;
import com.ujjwalagrawal.spectrum.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface NotificationListApi {
    //base interface to post on the server to query
    @GET(Urls.REQUEST_NOTIFICATIONS)
    Call<NotificationData> requestNotificationList(@Query("access_token") String access_token );

}
