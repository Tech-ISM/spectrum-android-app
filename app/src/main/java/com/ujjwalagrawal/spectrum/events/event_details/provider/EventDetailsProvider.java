package com.ujjwalagrawal.spectrum.events.event_details.provider;

import com.ujjwalagrawal.spectrum.events.event_details.EventDetailsCallback;

public interface EventDetailsProvider {
    void getEventDetails(int event_id, EventDetailsCallback eventDetailsCallback);
}
