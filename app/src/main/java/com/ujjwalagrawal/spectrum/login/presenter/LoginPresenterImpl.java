package com.ujjwalagrawal.spectrum.login.presenter;


import com.ujjwalagrawal.spectrum.login.LoginCallback;
import com.ujjwalagrawal.spectrum.login.data.LoginResponse;
import com.ujjwalagrawal.spectrum.login.provider.LoginHelper;
import com.ujjwalagrawal.spectrum.login.view.LoginView;

/**
 * Created by samveg on 30/7/17.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginHelper loginHelper;
    private LoginView login;
    public LoginPresenterImpl(LoginView login, LoginHelper loginHelper) {
        this.login = login;
        this.loginHelper = loginHelper;
    }


    @Override
    public void getLoginData(String name,String mobile,String email) {

        login.showProgressBar(true);
        loginHelper.loginData(name,mobile,email,new LoginCallback() {
            @Override
            public void onLoginSuccess(LoginResponse loginResponse) {
                login.showProgressBar(false);
                if(loginResponse.isSuccess()) {
                    login.showLoginStatus(loginResponse);
                }
                else{
                    login.showError(loginResponse.getMessage());
                }
            }
            @Override
            public void onLoginFailure(String error) {
                login.showError("Sorry!!Something went wrong");
                login.showProgressBar(false);
                login.checkNetwork();
            }
        });
    }
}
