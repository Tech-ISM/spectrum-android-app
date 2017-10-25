package com.ujjwalagrawal.spectrum.login;


import com.ujjwalagrawal.spectrum.login.data.LoginResponse;

/**
 * Created by ujjwal on 24/10/17.
 */

public interface LoginCallback {

    void onLoginSuccess(LoginResponse loginResponse);
    void onLoginFailure(String error);
}
