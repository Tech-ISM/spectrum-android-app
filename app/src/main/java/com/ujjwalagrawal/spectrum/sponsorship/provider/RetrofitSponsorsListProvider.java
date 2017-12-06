package com.ujjwalagrawal.spectrum.sponsorship.provider;

import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.sponsorship.SponsorshipCallback;
import com.ujjwalagrawal.spectrum.sponsorship.api.SponsorsListApi;
import com.ujjwalagrawal.spectrum.sponsorship.model.SponsorshipResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nosta on 26-10-2017.
 */

public class RetrofitSponsorsListProvider implements SponsorsListProvider {
        SponsorsListApi sponsorsListApi;

    public RetrofitSponsorsListProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).
                addConverterFactory(GsonConverterFactory.create()).build();
        sponsorsListApi=retrofit.create(SponsorsListApi.class);
    }

    @Override
    public void RequestSponsorsList(final SponsorshipCallback sponsorshipCallback) {

        Call<SponsorshipResponse> call = sponsorsListApi.getSponsors();
        call.enqueue(new Callback<SponsorshipResponse>() {
            @Override
            public void onResponse(Call<SponsorshipResponse> call, Response<SponsorshipResponse> response) {
                sponsorshipCallback.onSponsorshipSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SponsorshipResponse> call, Throwable t) {
                t.printStackTrace();
                sponsorshipCallback.onSponsorshipFailure("Network Error");

            }
        });

    }
}
