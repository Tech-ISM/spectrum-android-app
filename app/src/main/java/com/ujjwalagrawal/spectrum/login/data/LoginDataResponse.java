package com.ujjwalagrawal.spectrum.login.data;

/**
 * Created by samveg on 30/7/17.
 */

public class LoginDataResponse {

    private boolean success;
    private String message, token;
    public LoginDataResponse(boolean success, String message, String token)
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
