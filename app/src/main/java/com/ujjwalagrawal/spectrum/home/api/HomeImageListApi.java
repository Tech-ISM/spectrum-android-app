package com.ujjwalagrawal.spectrum.home.api;

import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.home.model.HomeImageResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hp-p on 17-Jan-18.
 */

public interface HomeImageListApi {
//    @GET(Urls.REQUEST_HOMEIMAGES)
    Call<HomeImageResponse> getHomeImages();
}
