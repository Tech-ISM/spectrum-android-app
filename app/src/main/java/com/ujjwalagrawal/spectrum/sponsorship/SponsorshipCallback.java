package com.ujjwalagrawal.spectrum.sponsorship;

import com.ujjwalagrawal.spectrum.sponsorship.model.SponsorshipResponse;

/**
 * Created by shubham on 25-10-2017.
 */

public interface SponsorshipCallback {
    void onSponsorshipSuccess(SponsorshipResponse sponsorshipResponse);
    void onSponsorshipFailure(String error);

}
