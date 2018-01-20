package com.ujjwalagrawal.spectrum.splash_screen.model;

import com.ujjwalagrawal.spectrum.splash_screen.model.data.SplashScreenData;
import rx.Observable;

public interface SplashScreenProvider {
    Observable<SplashScreenData> insertFcm(String fcm, String access_token);
}
