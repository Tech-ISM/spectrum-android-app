package com.ujjwalagrawal.spectrum.events.event_list;

import com.ujjwalagrawal.spectrum.events.event_list.data.EventList;

/**
 * Created by ujjwal on 25/10/17.
 */

public interface EventListCallback {
	void onSuccess(EventList eventList);
	void onFailure();
}
