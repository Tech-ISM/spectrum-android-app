package com.ujjwalagrawal.spectrum.profile.model;

/**
 * Created by nosta on 16-01-2018.
 */

public class RegistrationDetail {
    public boolean success;
    public String message;

    public RegistrationDetail(boolean success, String message) {

        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
