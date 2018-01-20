package com.ujjwalagrawal.spectrum.splash_screen.view;


import com.ujjwalagrawal.spectrum.splash_screen.model.data.SplashScreenData;

public interface SplashScreenView {

    void showMessage(String message);

    void fcmInsertStatus(SplashScreenData splashScreenData);

    void showProgressBar(boolean show);

    void showDialog(String s);
}
