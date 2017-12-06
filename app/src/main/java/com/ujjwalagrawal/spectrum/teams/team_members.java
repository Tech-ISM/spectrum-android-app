package com.ujjwalagrawal.spectrum.teams;

/**
 * Created by hp-p on 28-Oct-17.
 */

public class team_members {
    private String name;
    private String designation;
    private int image;
    private String mobile_no;
    private String facebook_url;
    private String github_url;
    private String LinkedIn_url;

    public team_members(String name, String designation, int image, String m_no, String fb_url, String g_url, String L_url) {
        this.name = name;
        this.designation = designation;
        this.image = image;
        this.facebook_url = fb_url;
        this.mobile_no = m_no;
        this.github_url = g_url;
        this.LinkedIn_url = L_url;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public int getImage() {
        return image;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public String getFacebook_url() {
        return facebook_url;
    }

    public String getGithub_url() {
        return github_url;
    }

    public String getLinkedIn_url() {
        return LinkedIn_url;
    }
}

