package com.ujjwalagrawal.spectrum.events.event_list.provider;

import com.ujjwalagrawal.spectrum.events.event_list.EventListCallback;

/**
 * Created by ujjwal on 25/10/17.
 */

public interface EventListProvider {
	void requestEventList(int day, EventListCallback eventListCallback);
}
