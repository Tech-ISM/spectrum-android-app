package com.ujjwalagrawal.spectrum.otp_verify.api;


import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.otp_verify.model.OtpResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ujjwal on 24/10/17.
 */

public interface RequestOtpVerify {

    @FormUrlEncoded
    @POST(Urls.REQUEST_VERIFY)
    Call<OtpResponse> getJson(@Field("otp") String otp, @Field("mobile") String mobile, @Field("token") String access_token);
}
