package com.ujjwalagrawal.spectrum.sponsorship.model;


import java.util.List;

/**
 * Created by shubham on 25-10-2017.
 */

public class SponsorshipResponse {
    private String message;
    private boolean success;
    private List<SponsorsDetails> sponsorsDetailsList;

    public SponsorshipResponse(String message, boolean success, List<SponsorsDetails> sponsorsDetailsList) {
        this.message = message;
        this.success = success;
        this.sponsorsDetailsList = sponsorsDetailsList;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<SponsorsDetails> getSponsorsDetailsList() {
        return sponsorsDetailsList;
    }
}