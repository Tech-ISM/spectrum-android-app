package com.ujjwalagrawal.spectrum.helper.fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.helper.Keys;
import com.ujjwalagrawal.spectrum.splash_screen.view.SplashScreen;

/**
 * Created by ramya on 25/3/17.
 */

public class MyFirebaseService extends FirebaseMessagingService {

    private String TAG = "MyFirebaseService";
    private static int nid = 0;
    private Bitmap bitmap;
    private String imageUri;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            Log.d(TAG, "Message Notification Click Action: " + remoteMessage.getNotification().getClickAction());

        }
        sendNotification(remoteMessage);

    }


    private void sendNotification(RemoteMessage remoteMessage) {
        Intent intent = new Intent(this, SplashScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(Keys.KEY_FCM_ACTIVITY, true);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, nid++ /* Request code*/, intent,
                PendingIntent.FLAG_ONE_SHOT);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Spectrum ")
                .setContentText(remoteMessage.getData().get("message"))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle("Spectrum"))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(remoteMessage.getData().get("message")))
                .setSound(defaultSoundUri).setSmallIcon(R.drawable.app_logo);

        Log.d("value of nid", String.valueOf(nid));

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(nid  /*ID of notification*/, notificationBuilder.build());

    }


}
