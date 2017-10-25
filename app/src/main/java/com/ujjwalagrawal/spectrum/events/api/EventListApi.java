package com.ujjwalagrawal.spectrum.events.api;



import com.ujjwalagrawal.spectrum.events.data.EventList;
import com.ujjwalagrawal.spectrum.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by ujjwal on 25/10/17.
 */

public interface EventListApi {
    @GET(Urls.REQUEST_EVENTS)
    Call<EventList> getEvents(@Query("day") int day);
}
