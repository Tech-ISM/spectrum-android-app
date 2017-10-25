package com.ujjwalagrawal.spectrum.events.provider;

import com.ujjwalagrawal.spectrum.events.EventListCallback;
import com.ujjwalagrawal.spectrum.events.api.EventListApi;
import com.ujjwalagrawal.spectrum.events.data.EventList;
import com.ujjwalagrawal.spectrum.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ujjwal on 25/10/17.
 */

public class RetrofitEventListProvider implements EventListProvider {

	EventListApi eventListApi;
	public RetrofitEventListProvider() {
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).
				addConverterFactory(GsonConverterFactory.create()).build();
		eventListApi = retrofit.create(EventListApi.class);
	}

	@Override
	public void requestEventList(int day, final EventListCallback eventListCallback) {
		Call<EventList> call =eventListApi.getEvents(day);
		call.enqueue(new Callback<EventList>() {
			@Override
			public void onResponse(Call<EventList> call, Response<EventList> response) {
				eventListCallback.onSuccess(response.body());
			}

			@Override
			public void onFailure(Call<EventList> call, Throwable t) {
				t.printStackTrace();
				eventListCallback.onFailure();
			}
		});
	}
}
