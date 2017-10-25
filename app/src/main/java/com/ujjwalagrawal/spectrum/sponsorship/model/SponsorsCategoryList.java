package com.ujjwalagrawal.spectrum.sponsorship.model;

import java.util.List;

/**
 * Created by nosta on 25-10-2017.
 */

public class SponsorsCategoryList {
    private String category_name;
    private List<SponsorsDetails> sponsorsDetail;


    public SponsorsCategoryList(String category_name, List<SponsorsDetails> sponsorsDetail) {
        this.category_name = category_name;
        this.sponsorsDetail = sponsorsDetail;
    }

    public String getCategory_name() {
        return category_name;
    }

    public List<SponsorsDetails> getSponsorsDetail() {
        return sponsorsDetail;
    }
}
