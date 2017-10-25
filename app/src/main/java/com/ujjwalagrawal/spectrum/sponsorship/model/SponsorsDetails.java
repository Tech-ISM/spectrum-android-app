package com.ujjwalagrawal.spectrum.sponsorship.model;

/**
 * Created by shubham on 25-10-2017.
 */

public class SponsorsDetails {
    private String name;
    private String image_url;
    private String category_id;
    private String mobile_no;
    private String facebook_url;
    private String website_url;

    public SponsorsDetails(String name, String image_url, String category_id,String mobile_no,String facebook_url,String website_url){
        this.name=name;
        this.image_url=image_url;
        this.category_id=category_id;
        this.mobile_no=mobile_no;
        this.facebook_url=facebook_url;
        this.website_url=website_url;
    }

    public String getName(){return name;}
    public String getImage_url(){return image_url;}
    public String getCategory_id(){return category_id;}
    public String getMobile_no(){return mobile_no;}
    public String getFacebook_url(){return facebook_url;}
    public String getWebsite_url(){return website_url;}

}




