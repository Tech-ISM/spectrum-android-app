package com.ujjwalagrawal.spectrum.sponsorship.view;

import com.ujjwalagrawal.spectrum.sponsorship.model.SponsorshipResponse;

/**
 * Created by nosta on 25-10-2017.
 */

public interface SponsorsView {
    void showProgressBar(boolean show);
    void showError(String message);
    void showSponsorStatus(SponsorshipResponse sponsorshipResponse);
    void checkNetwork();
}
