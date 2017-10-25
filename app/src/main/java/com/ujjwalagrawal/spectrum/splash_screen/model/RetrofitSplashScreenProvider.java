package com.ujjwalagrawal.spectrum.splash_screen.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.splash_screen.api.SplashScreenRequestApi;
import com.ujjwalagrawal.spectrum.splash_screen.model.data.SplashScreenData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by ujjwal on 25/10/17.
 */

public class RetrofitSplashScreenProvider implements SplashScreenProvider{

    private Retrofit retrofit;
    private SplashScreenRequestApi splashScreenRequestApi;

    public RetrofitSplashScreenProvider(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        splashScreenRequestApi = retrofit.create(SplashScreenRequestApi.class);
    }

    @Override
    public Observable<SplashScreenData> insertFcm(String fcm, String access_token) {
        return splashScreenRequestApi.insertFcm(fcm,access_token);
    }
}
