package com.ujjwalagrawal.spectrum.events.event_details.api;

import com.ujjwalagrawal.spectrum.events.event_details.data.EventDetails;
import com.ujjwalagrawal.spectrum.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventDetailsApi {
    @GET(Urls.GET_EVENTS_DETAILS)
    Call<EventDetails> getEventDetails(@Query("event_id") int event_id);
}
