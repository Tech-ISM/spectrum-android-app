package com.ujjwalagrawal.spectrum.notifications.presenter;

import com.ujjwalagrawal.spectrum.notifications.NotificationListCallback;
import com.ujjwalagrawal.spectrum.notifications.data.NotificationData;
import com.ujjwalagrawal.spectrum.notifications.provider.NotificationListProvider;
import com.ujjwalagrawal.spectrum.notifications.view.NotificationListView;

public class NotificationListPresenterImpl implements NotificationListPresenter {
    private NotificationListView notificationListView;
    private NotificationListProvider notificationListProvider;

    public NotificationListPresenterImpl(NotificationListView notificationListView, NotificationListProvider notificationListProvider) {
        this.notificationListView = notificationListView;
        this.notificationListProvider = notificationListProvider;
    }

    @Override
    public void requestNotificationList(String access_token) {
        notificationListView.ShowProgressBar(true);
        notificationListProvider.requestNotificationList(access_token, new NotificationListCallback() {
            @Override
            public void onFailed() {
                notificationListView.ShowProgressBar(false);
                notificationListView.showMessage("Unable to connect to Server");
            }

            @Override
            public void onSuccess(NotificationData notificationData) {
                notificationListView.ShowProgressBar(false);
                if (notificationData.isSuccess()){
                    notificationListView.setData(notificationData);
                }else {
                    notificationListView.showMessage(notificationData.getMessage());
                }
            }
        });
    }
}
