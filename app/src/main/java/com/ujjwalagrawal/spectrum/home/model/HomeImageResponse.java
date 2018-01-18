package com.ujjwalagrawal.spectrum.home.model;
import java.util.List;

/**
 * Created by hp-p on 17-Jan-18.
 */

public class HomeImageResponse {
    private String message;
    private boolean success;
    private List<HomeImageDetails> HomeImageDetailsList;

    public HomeImageResponse(String message, boolean success, List<HomeImageDetails> HomeImageDetailList) {
        this.message = message;
        this.success = success;
        this.HomeImageDetailsList = HomeImageDetailList;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<HomeImageDetails> getHomeImageDetailsList() {
        return HomeImageDetailsList;
    }
}
