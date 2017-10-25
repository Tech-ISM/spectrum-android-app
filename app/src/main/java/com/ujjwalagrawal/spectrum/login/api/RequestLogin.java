package com.ujjwalagrawal.spectrum.login.api;

import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.login.data.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ujjwal on 24/10/17.
 */

public interface RequestLogin {

    @FormUrlEncoded
    @POST(Urls.REQUEST_LOGIN)
    Call<LoginResponse> getJSON(@Field("name") String name, @Field("mobile_no") String mobile, @Field("email") String email);
}
