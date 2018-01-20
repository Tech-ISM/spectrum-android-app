package com.ujjwalagrawal.spectrum.notifications;

import com.ujjwalagrawal.spectrum.notifications.data.NotificationData;

public interface NotificationListCallback {
    void onFailed();
    void onSuccess(NotificationData notificationData);
}
