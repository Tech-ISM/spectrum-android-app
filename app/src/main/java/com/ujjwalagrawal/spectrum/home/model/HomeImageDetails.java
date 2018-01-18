package com.ujjwalagrawal.spectrum.home.model;

/**
 * Created by hp-p on 17-Jan-18.
 */

public class HomeImageDetails {
    private String image_url;
    private String onimageclick_url;
    private int res_id;

    public HomeImageDetails( String image_url, String onimageclick_url,int res_id) {
        this.image_url = image_url;
        this.onimageclick_url = onimageclick_url;
        this.res_id=res_id;
    }
    public String getImage_url() {
        return image_url;
    }
    public String getOnimageclick_url() {
        return onimageclick_url;
    }

    public int getRes_id() {
        return res_id;
    }
}
