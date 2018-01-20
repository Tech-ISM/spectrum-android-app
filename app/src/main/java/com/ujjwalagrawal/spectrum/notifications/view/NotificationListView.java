package com.ujjwalagrawal.spectrum.notifications.view;

import com.ujjwalagrawal.spectrum.notifications.data.NotificationData;

public interface NotificationListView {
    void ShowProgressBar(boolean show);
    void showMessage(String message);
    void setData(NotificationData notificationData);
}
