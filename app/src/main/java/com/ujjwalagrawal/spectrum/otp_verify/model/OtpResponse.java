package com.ujjwalagrawal.spectrum.otp_verify.model;

/**
 * Created by ujjwal on 24/10/17.
 */

public class OtpResponse {

    private String message;
    private boolean success;
    public OtpResponse(String message, boolean success)
    {
        this.message=message;
        this.success=success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
