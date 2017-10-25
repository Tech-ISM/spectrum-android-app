package com.ujjwalagrawal.spectrum.events.data;

/**
 * Created by ujjwal on 25/10/17.
 */

public class EventData {
	private String name;
	private String image_url;
	private int event_id;

	public EventData(String name, String image_url, int event_id) {
		this.name = name;
		this.image_url = image_url;
		this.event_id = event_id;
	}

	public String getName() {
		return name;
	}

	public String getImage_url() {
		return image_url;
	}

	public int getEvent_id() {
		return event_id;
	}

}
