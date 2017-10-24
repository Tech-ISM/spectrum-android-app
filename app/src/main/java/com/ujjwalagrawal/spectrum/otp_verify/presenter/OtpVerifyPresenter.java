package com.ujjwalagrawal.spectrum.otp_verify.presenter;

/**
 * Created by ujjwal on 24/10/17.
 */
public interface OtpVerifyPresenter {

    void getOtpResponse(String otp, String mobile, String access_token);
    void onDestroy();
}
