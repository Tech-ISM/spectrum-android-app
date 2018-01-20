package com.ujjwalagrawal.spectrum.notifications.data;

public class NotificationsDetails {

    private String title;
    private String message;
    private String time;
    private String date;
    private int event_id;

    public NotificationsDetails(String title, String message, String time, String date, int event_id) {
        this.title = title;
        this.message = message;
        this.time = time;
        this.date = date;
        this.event_id = event_id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public int getEvent_id() {
        return event_id;
    }
}
