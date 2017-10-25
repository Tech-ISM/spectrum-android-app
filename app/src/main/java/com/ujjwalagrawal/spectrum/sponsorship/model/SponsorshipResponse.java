package com.ujjwalagrawal.spectrum.sponsorship.model;


import java.util.List;

/**
 * Created by shubham on 25-10-2017.
 */

public class SponsorshipResponse {
    private String message;
    private boolean success;
    private List<SponsorsDetails> sponsors_list;


    public SponsorshipResponse(String message, boolean success, List<SponsorsDetails> sponsors_list)
    {
        this.message=message;
        this.success=success;
        this.sponsors_list=sponsors_list;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<SponsorsDetails> getSponsors_list() {return sponsors_list;}
}


