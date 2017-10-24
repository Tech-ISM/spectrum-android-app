package com.ujjwalagrawal.spectrum.login.provider;


import com.ujjwalagrawal.spectrum.login.LoginCallback;

/**
 * Created by samveg on 30/7/17.
 */

public interface LoginHelper {

    void loginData(String name, String mobile, String email, LoginCallback loginCallback);
}
