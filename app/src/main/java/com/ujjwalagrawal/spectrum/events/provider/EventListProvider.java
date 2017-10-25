package com.ujjwalagrawal.spectrum.events.provider;

import com.ujjwalagrawal.spectrum.events.EventListCallback;

/**
 * Created by ujjwal on 25/10/17.
 */

public interface EventListProvider {
	void requestEventList(int day, EventListCallback eventListCallback);
}
