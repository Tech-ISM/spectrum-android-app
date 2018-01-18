package com.ujjwalagrawal.spectrum.home.provider;

import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.home.HomeImagesCallback;
import com.ujjwalagrawal.spectrum.home.api.HomeImageListApi;
import com.ujjwalagrawal.spectrum.home.model.HomeImageResponse;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by hp-p on 17-Jan-18.
 */

public class RetroHomeImageListprovider implements HomeImageListProvider{
    HomeImageListApi homeImageListApi;

    public RetroHomeImageListprovider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).
                addConverterFactory(GsonConverterFactory.create()).build();
        homeImageListApi=retrofit.create(HomeImageListApi.class);
    }

    @Override
    public void RequestHomeImagesList(final HomeImagesCallback homeImagesCallback) {

        Call<HomeImageResponse> call = homeImageListApi.getHomeImages();
        call.enqueue(new Callback<HomeImageResponse>() {
            @Override
            public void onResponse(Call<HomeImageResponse> call, Response<HomeImageResponse> response) {
                homeImagesCallback.onHomeImageSuccess(response.body());
            }

            @Override
            public void onFailure(Call<HomeImageResponse> call, Throwable t) {
                t.printStackTrace();
                homeImagesCallback.onHomeImageFailure("Network Error");

            }
        });

    }
}
