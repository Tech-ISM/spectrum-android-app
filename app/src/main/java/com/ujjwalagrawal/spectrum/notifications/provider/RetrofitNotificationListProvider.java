package com.ujjwalagrawal.spectrum.notifications.provider;

import com.ujjwalagrawal.spectrum.notifications.NotificationListCallback;
import com.ujjwalagrawal.spectrum.notifications.api.NotificationListApi;
import com.ujjwalagrawal.spectrum.notifications.data.NotificationData;
import com.ujjwalagrawal.spectrum.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNotificationListProvider implements NotificationListProvider {

    private NotificationListApi notificationListApi;
    public RetrofitNotificationListProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).
                addConverterFactory(GsonConverterFactory.create()).build();
        notificationListApi = retrofit.create(NotificationListApi.class);
    }

    @Override
    public void requestNotificationList(String access_token, final NotificationListCallback notificationListCallback) {
        Call<NotificationData> notificationDataCall = notificationListApi.requestNotificationList(access_token);
        notificationDataCall.enqueue(new Callback<NotificationData>() {
            @Override
            public void onResponse(Call<NotificationData> call, Response<NotificationData> response) {
                notificationListCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<NotificationData> call, Throwable t) {
                notificationListCallback.onFailed();
                t.printStackTrace();
            }
        });
    }
}
