package com.ujjwalagrawal.spectrum.notifications.data;

import java.util.List;

public class NotificationData {
    private boolean success;
    private String message;
    private List<NotificationsDetails> notification_list;

    public NotificationData(boolean success, String message, List<NotificationsDetails> notification_list) {
        this.success = success;
        this.message = message;
        this.notification_list = notification_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<NotificationsDetails> getNotification_list() {
        return notification_list;
    }
}
