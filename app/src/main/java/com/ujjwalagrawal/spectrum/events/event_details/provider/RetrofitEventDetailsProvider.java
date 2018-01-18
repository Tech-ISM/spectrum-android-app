package com.ujjwalagrawal.spectrum.events.event_details.provider;

import com.ujjwalagrawal.spectrum.events.event_details.EventDetailsCallback;
import com.ujjwalagrawal.spectrum.events.event_details.api.EventDetailsApi;
import com.ujjwalagrawal.spectrum.events.event_details.data.EventDetails;
import com.ujjwalagrawal.spectrum.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitEventDetailsProvider implements EventDetailsProvider {
    EventDetailsApi eventDetailsApi;
    public RetrofitEventDetailsProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).
                addConverterFactory(GsonConverterFactory.create()).build();
        eventDetailsApi = retrofit.create(EventDetailsApi.class);
    }

    @Override
    public void getEventDetails(int event_id, final EventDetailsCallback eventDetailsCallback) {
        Call<EventDetails> call =eventDetailsApi.getEventDetails(event_id);
        call.enqueue(new Callback<EventDetails>() {
            @Override
            public void onResponse(Call<EventDetails> call, Response<EventDetails> response) {
                eventDetailsCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<EventDetails> call, Throwable t) {
                eventDetailsCallback.onFailed();
            }
        });


    }
}
