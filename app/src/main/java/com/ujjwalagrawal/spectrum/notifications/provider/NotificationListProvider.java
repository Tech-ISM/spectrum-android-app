package com.ujjwalagrawal.spectrum.notifications.provider;

import com.ujjwalagrawal.spectrum.notifications.NotificationListCallback;

public interface NotificationListProvider {
    void requestNotificationList(String access_token, NotificationListCallback notificationListCallback);
}
