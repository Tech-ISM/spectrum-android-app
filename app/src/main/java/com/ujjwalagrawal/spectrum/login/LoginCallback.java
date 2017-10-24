package com.ujjwalagrawal.spectrum.login;


import com.ujjwalagrawal.spectrum.login.data.LoginDataResponse;

/**
 * Created by samveg on 30/7/17.
 */

public interface LoginCallback {

    void onLoginSuccess(LoginDataResponse loginResponse);
    void onLoginFailure(String error);
}
