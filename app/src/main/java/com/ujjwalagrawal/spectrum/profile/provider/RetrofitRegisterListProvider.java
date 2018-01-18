package com.ujjwalagrawal.spectrum.profile.provider;



import com.ujjwalagrawal.spectrum.helper.SharedPrefs;
import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.profile.RegisterListCallback;
import com.ujjwalagrawal.spectrum.profile.api.ProfileApi;
import com.ujjwalagrawal.spectrum.profile.model.RegistrationList;

import retrofit2.Call;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nosta on 18-01-2018.
 */

public class RetrofitRegisterListProvider implements RegisterListProvider {
    ProfileApi profileApi;
    SharedPrefs sharedPrefs;


    public RetrofitRegisterListProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).
                addConverterFactory(GsonConverterFactory.create()).build();
       profileApi = retrofit.create(ProfileApi.class);
    }

    @Override
    public void requestRegistrationList(String token, final RegisterListCallback registerListCallback) {

       Call<RegistrationList> call = profileApi.getDetails(token);
       call.enqueue(new Callback<RegistrationList>() {
           @Override
           public void onResponse(Call<RegistrationList> call, Response<RegistrationList> response) {
               registerListCallback.onSuccess(response.body());
           }

           @Override
           public void onFailure(Call<RegistrationList> call, Throwable t) {

               t.printStackTrace();
               registerListCallback.onFailure();
           }
       });
    }
}
