package com.ujjwalagrawal.spectrum.profile.view;

import com.ujjwalagrawal.spectrum.profile.model.EventsList;

import java.util.List;

/**
 * Created by nosta on 17-01-2018.
 */

public interface RegisterListView {

    void SetData(List<EventsList> eventsListList);
    void showMessage(String message);
}
