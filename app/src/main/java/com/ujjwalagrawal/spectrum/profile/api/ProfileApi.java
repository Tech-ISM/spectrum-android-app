package com.ujjwalagrawal.spectrum.profile.api;

/**
 * Created by nosta on 16-01-2018.
 */
import android.net.nsd.NsdManager;

import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.profile.model.RegistrationDetail;
import com.ujjwalagrawal.spectrum.profile.model.RegistrationList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface  ProfileApi {
    @GET(Urls.REQUEST_PROFILE)
    Call<RegistrationList> getDetails(@Query("access_token") String token);

    @FormUrlEncoded
    @POST(Urls.REQUEST_REGISTER)
    Call<RegistrationDetail> getInfo (@Field("event_id") int id , @Field("participated") int participated , @Field("access_token") String token);

}


