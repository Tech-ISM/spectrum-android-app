package com.ujjwalagrawal.spectrum.events;

import com.ujjwalagrawal.spectrum.events.data.EventList;

/**
 * Created by ujjwal on 25/10/17.
 */

public interface EventListCallback {
	void onSuccess(EventList eventList);
	void onFailure();
}
