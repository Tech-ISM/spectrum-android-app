package com.ujjwalagrawal.spectrum.sponsorship.model;

/**
 * Created by shubham on 25-10-2017.
 */

public class SponsorsDetails {
    private String name;
    private String image_url;
    private String onimageclick_url;

    public SponsorsDetails(String name, String image_url, String onimageclick_url) {
        this.name = name;
        this.image_url = image_url;
        this.onimageclick_url = onimageclick_url;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getOnimageclick_url() {
        return onimageclick_url;
    }
}