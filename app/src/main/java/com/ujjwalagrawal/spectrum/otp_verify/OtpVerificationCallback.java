package com.ujjwalagrawal.spectrum.otp_verify;


import com.ujjwalagrawal.spectrum.otp_verify.model.OtpResponse;

/**
 * Created by ujjwal on 24/10/17.
 */

public interface OtpVerificationCallback {

    void onOtpVerified(OtpResponse otpResponse);
    void onFailure(String error);
}
