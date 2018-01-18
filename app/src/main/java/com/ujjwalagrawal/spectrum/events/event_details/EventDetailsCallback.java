package com.ujjwalagrawal.spectrum.events.event_details;

import com.ujjwalagrawal.spectrum.events.event_details.data.EventDetails;

public interface EventDetailsCallback {
    void onFailed();
    void onSuccess(EventDetails eventDetails);
}
