package com.ujjwalagrawal.spectrum.sponsorship.api;

import com.ujjwalagrawal.spectrum.helper.Urls;
import com.ujjwalagrawal.spectrum.sponsorship.model.SponsorshipResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by shubham on 25-10-2017.
 */

public interface SponsorsListApi {
    @GET(Urls.REQUEST_SPONS)
    Call<SponsorshipResponse> getSponsors();
}   