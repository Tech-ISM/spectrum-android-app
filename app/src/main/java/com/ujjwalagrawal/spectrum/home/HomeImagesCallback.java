package com.ujjwalagrawal.spectrum.home;

import com.ujjwalagrawal.spectrum.home.model.HomeImageResponse;

/**
 * Created by hp-p on 17-Jan-18.
 */

public interface HomeImagesCallback {
    void onHomeImageSuccess(HomeImageResponse homeImageResponse);
    void onHomeImageFailure(String error);
}
