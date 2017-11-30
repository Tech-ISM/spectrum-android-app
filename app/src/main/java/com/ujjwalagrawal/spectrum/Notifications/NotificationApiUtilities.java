package com.ujjwalagrawal.spectrum;

import android.content.Context;

import com.ujjwalagrawal.spectrum.R;

/**
 * Created by Lenovo on 25-10-2017.
 */

public class NotificationApiUtilities {

    private NotificationApiUtilities() {
    }

    //TODO:Get the base  api link
    public static final String BASE_URL = "https://ss.com";
    public static ApiNotificationsService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiNotificationsService.class);
    }
}
