package com.ujjwalagrawal.spectrum.login;


import com.ujjwalagrawal.spectrum.login.data.LoginDataResponse;

/**
 * Created by ujjwal on 24/10/17.
 */

public interface LoginCallback {

    void onLoginSuccess(LoginDataResponse loginResponse);
    void onLoginFailure(String error);
}
