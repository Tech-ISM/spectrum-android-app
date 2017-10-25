package com.ujjwalagrawal.spectrum.splash_screen.view;


import com.ujjwalagrawal.spectrum.splash_screen.model.data.SplashScreenData;

/**
 * Created by ujjwal on 25/10/17.
 */

public interface SplashScreenView {

    void showMessage(String message);

    void fcmInsertStatus(SplashScreenData splashScreenData);

    void showProgressBar(boolean show);
}
