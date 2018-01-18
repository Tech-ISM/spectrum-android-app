package com.ujjwalagrawal.spectrum.splash_screen.model.data;


public class SplashScreenData {

    private boolean success;
    private String message;
    private float version;
    private String url;

    public SplashScreenData(boolean success, String message, float version, String url) {
        this.success = success;
        this.message = message;
        this.version = version;
        this.url = url;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public float getVersion() {
        return version;
    }

    public String getUrl() {
        return url;
    }
}
