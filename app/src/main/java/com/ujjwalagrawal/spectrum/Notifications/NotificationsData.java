package com.ujjwalagrawal.spectrum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 25-10-2017.
 */

public class NotificationsData {

    /**
     * @Serialised targets the variable name in the json object
     * @Expose that value in the variable
     * */
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("event_id")
    @Expose
    private String event_id;

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getEvent_id(){
        return event_id;
    }
    public void setEvent_id(String event_id){
        this.event_id = event_id;
    }

}
