package com.ujjwalagrawal.spectrum.events.event_details.view;

import com.ujjwalagrawal.spectrum.events.event_details.data.EventDetails;

public interface EventDetailsView {
    void showProgressbar(boolean show);
    void showMessage(String message);
    void setEventDetails(EventDetails eventDetails);
}
