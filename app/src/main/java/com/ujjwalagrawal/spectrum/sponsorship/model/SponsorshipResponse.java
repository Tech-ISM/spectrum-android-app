package com.ujjwalagrawal.spectrum.sponsorship.model;


import java.util.List;

/**
 * Created by shubham on 25-10-2017.
 */

public class SponsorshipResponse {
    private String message;
    private boolean success;
    private List<SponsorsCategoryList> sponsorscategory_list;

    public SponsorshipResponse(String message, boolean success, List<SponsorsCategoryList> sponsorscategory_list) {
        this.message = message;
        this.success = success;
        this.sponsorscategory_list = sponsorscategory_list;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<SponsorsCategoryList> getSponsorscategory_list() {
        return sponsorscategory_list;
    }
}


