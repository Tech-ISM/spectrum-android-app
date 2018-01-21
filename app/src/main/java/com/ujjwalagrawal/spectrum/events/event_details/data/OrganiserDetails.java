package com.ujjwalagrawal.spectrum.events.event_details.data;

public class OrganiserDetails {
    public String name;
    public String mobile;

    public OrganiserDetails(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }
}
