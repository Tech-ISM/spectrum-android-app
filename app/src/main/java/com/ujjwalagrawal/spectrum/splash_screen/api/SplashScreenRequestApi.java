package com.ujjwalagrawal.spectrum.splash_screen.api;


import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.splash_screen.model.data.SplashScreenData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ujjwal on 25/10/17.
 */

public interface SplashScreenRequestApi {
    @GET(Urls.REQUEST_SPLASH_SCREEN)
    Observable<SplashScreenData> insertFcm(@Query("fcm") String fcm, @Query("access_token") String access_token);
}
