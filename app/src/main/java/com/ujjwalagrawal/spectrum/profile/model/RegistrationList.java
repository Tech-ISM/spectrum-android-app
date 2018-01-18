package com.ujjwalagrawal.spectrum.profile.model;

import java.util.List;

/**
 * Created by nosta on 16-01-2018.
 */

public class RegistrationList {
    public boolean success;
    public String message;
    public List<EventsList> event_list;

    public RegistrationList(boolean success, String message, List<EventsList> event_list) {
        this.success = success;
        this.message = message;
        this.event_list = event_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<EventsList> getEvent_list() {
        return event_list;
    }
}
