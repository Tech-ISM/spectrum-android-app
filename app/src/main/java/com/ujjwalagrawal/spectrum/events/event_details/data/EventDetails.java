package com.ujjwalagrawal.spectrum.events.event_details.data;

import java.util.List;

public class EventDetails {
    private boolean success;
    private String message;
    private String name;
    private String round_name;
    private String image;
    private String image_blur;
    private String time;
    private String date;
    private String location;
    private String description;
    private String rules;
    private String prize_description;
    private List<OrganiserDetails> oragniser_list;
    private int type;
    private int attendees;
    private int day;


    public EventDetails(boolean success, String message, String name, String round_name, String image, String image_blur, String time, String date, String location, String description, String rules, String prize_description, List<OrganiserDetails> oragniser_list, int type, int attendees, int day) {
        this.success = success;
        this.message = message;
        this.name = name;
        this.round_name = round_name;
        this.image = image;
        this.image_blur = image_blur;
        this.time = time;
        this.date = date;
        this.location = location;
        this.description = description;
        this.rules = rules;
        this.prize_description = prize_description;
        this.oragniser_list = oragniser_list;
        this.type = type;
        this.attendees = attendees;
        this.day = day;
    }

    public String getRound_name() {
        return round_name;
    }

    public String getRules() {
        return rules;
    }

    public List<OrganiserDetails> getOragniser_list() {
        return oragniser_list ;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getImage_blur() {
        return image_blur;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getPrize_description() {
        return prize_description;
    }

    public int getType() {
        return type;
    }

    public int getAttendees() {
        return attendees;
    }

    public int getDay() {
        return day;
    }
}
