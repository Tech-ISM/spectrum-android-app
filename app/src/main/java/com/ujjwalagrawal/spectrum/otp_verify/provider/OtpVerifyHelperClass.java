package com.ujjwalagrawal.spectrum.otp_verify.provider;


import com.ujjwalagrawal.spectrum.otp_verify.OtpVerificationCallback;

/**
 * Created by ujjwal on 24/10/17.
 */

public interface OtpVerifyHelperClass {

    void getOtpResponse(String otp, String mobile, String access_token, OtpVerificationCallback otpVerificationCallback);
    void onDestroy();
}
