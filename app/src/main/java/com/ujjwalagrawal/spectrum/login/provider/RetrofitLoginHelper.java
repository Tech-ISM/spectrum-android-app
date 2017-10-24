package com.ujjwalagrawal.spectrum.login.provider;

import com.bquiz.raipur.ecellapp2k17.helper.Urls;
import com.bquiz.raipur.ecellapp2k17.login.LoginCallback;
import com.bquiz.raipur.ecellapp2k17.login.api.RequestLogin;
import com.bquiz.raipur.ecellapp2k17.login.model.LoginDataResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 30/7/17.
 */

public class RetrofitLoginHelper implements LoginHelper {

    private static String TAG ="RetrofitLoginHelper";

    @Override
    public void loginData(String name, String mobile, String email, final LoginCallback loginCallback) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).addInterceptor(interceptor).build();

        Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        RequestLogin requestLogin = retrofit.create(RequestLogin.class);
        Call<LoginDataResponse> call= requestLogin.getJSON(name,mobile,email);
        call.enqueue(new Callback<LoginDataResponse>() {
            @Override
            public void onResponse(Call<LoginDataResponse> call, Response<LoginDataResponse> response) {
                loginCallback.onLoginSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginDataResponse> call, Throwable t) {
                loginCallback.onLoginFailure(t.getMessage());
            }
        });
    }


}
