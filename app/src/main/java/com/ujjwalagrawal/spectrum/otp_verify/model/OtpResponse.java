package com.ujjwalagrawal.spectrum.otp_verify.model;

/**
 * Created by ujjwal on 24/10/17.
 */

public class OtpResponse {

    private String message;
    private boolean success;
    private String access_token;

    public OtpResponse(String message, boolean success, String access_token) {
        this.message = message;
        this.success = success;
        this.access_token = access_token;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getAccess_token() {
        return access_token;
    }
}
