package com.ujjwalagrawal.spectrum.events.data;

/**
 * Created by ujjwal on 25/10/17.
 */

public class EventData {
	private String name;
	private String image_url;
	private int event_id;
	private int day;

	public EventData(String name, String image_url, int event_id, int day) {
		this.name = name;
		this.image_url = image_url;
		this.event_id = event_id;
		this.day = day;
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

	public int getDay() {
		return day;
	}
}
