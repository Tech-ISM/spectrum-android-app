package com.ujjwalagrawal.spectrum.events.event_list.data;

public class EventData {
	private String name;
	private String image_url;
	private String time;
	private String round_name;
	private int event_id;


	public EventData(String name, String image_url, String time, String round_name, int event_id) {
		this.name = name;
		this.image_url = image_url;
		this.time = time;
		this.round_name = round_name;
		this.event_id = event_id;
	}

	public String getRound_name() {
		return round_name;
	}

	public String getTime() {
		return time;
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
