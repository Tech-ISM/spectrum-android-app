package com.ujjwalagrawal.spectrum.helper.fcm;

import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by meghalagrawal on 30/10/17.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private FcmUtils fcmUtils;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        fcmUtils=new FcmUtils(this);
        fcmUtils.sendFcmToServer();

    }
}
