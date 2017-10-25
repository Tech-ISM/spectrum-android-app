package com.ujjwalagrawal.spectrum.login.data;

/**
 * Created by ujjwal on 24/10/17.
 */

public class LoginResponse {

    private boolean success;
    private String message, token;
    public LoginResponse(boolean success, String message, String token)
    {
        this.message=message;
        this.success=success;
        this.token = token;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
    public String getToken(){
        return token;
    }
}
