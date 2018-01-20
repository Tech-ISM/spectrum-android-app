package com.ujjwalagrawal.spectrum.helper.fcm;

import android.content.Context;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ujjwalagrawal.spectrum.helper.SharedPrefs;
import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.notifications.api.FcmUpdateApi;
import com.ujjwalagrawal.spectrum.notifications.data.FcmUpdateData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


public class FcmUtils {

    private Retrofit retrofit;
    private SharedPrefs sharedPrefs;
    private Context context;
    public FcmUtils(Context context){
        this.context =context;
        sharedPrefs = new SharedPrefs(context);
    }

    public void sendFcmToServer(){
        String fcm_token;
        try {
            fcm_token = FirebaseInstanceId.getInstance().getToken();
            Log.d(TAG, "Fcmis2 " + fcm_token);
        } catch (Exception e) {
            e.printStackTrace();
            fcm_token = "fcmisnull1";
        }
        Log.d(TAG,"MyFirebaseInstanceIdService - "+fcm_token);


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES).build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        FcmUpdateApi fcmUpdateApi=retrofit.create(FcmUpdateApi.class);



        Call<FcmUpdateData> call=fcmUpdateApi.updateFcm(fcm_token,sharedPrefs.getAccessToken());


        call.enqueue(new Callback<FcmUpdateData>() {
            @Override
            public void onResponse(Call<FcmUpdateData> call, Response<FcmUpdateData> response) {
                Log.d(TAG,response.message());
            }

            @Override
            public void onFailure(Call<FcmUpdateData> call, Throwable t) {
                t.printStackTrace();
            }
        });



    }
}
