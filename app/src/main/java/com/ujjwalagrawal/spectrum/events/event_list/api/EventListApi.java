package com.ujjwalagrawal.spectrum.events.event_list.api;



import com.ujjwalagrawal.spectrum.events.event_list.data.EventList;
import com.ujjwalagrawal.spectrum.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by ujjwal on 25/10/17.
 */

public interface EventListApi {
    @GET(Urls.GET_EVENTS_LIST)
    Call<EventList> getEvents(@Query("day") int day);
}
