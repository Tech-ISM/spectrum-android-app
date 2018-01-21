package com.ujjwalagrawal.spectrum.events.event_list.data;

import java.util.List;

public class EventList {
	public boolean success;
	public String message;
	public List<EventData> event_list;

	public EventList(boolean success, String message, List<EventData> event_list) {
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

	public List<EventData> getEvent_list() {
		return event_list;
	}
}
