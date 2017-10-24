package com.ujjwalagrawal.spectrum.login.view;


import com.ujjwalagrawal.spectrum.login.data.LoginDataResponse;

/**
 * Created by samveg on 30/7/17.
 */

public interface LoginView {

    void showProgressBar(boolean show);
    void showLoginStatus(LoginDataResponse loginDataResponse);
    void showError(String message);
    void checkNetwork();
}
