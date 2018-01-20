package com.ujjwalagrawal.spectrum.notifications.data;

/**
 * Created by meghalagrawal on 30/10/17.
 */

public class FcmUpdateData {
    private boolean success;
    private String message;

    public FcmUpdateData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
