package com.ujjwalagrawal.spectrum.profile;

import com.ujjwalagrawal.spectrum.profile.model.RegistrationDetail;

/**
 * Created by nosta on 19-01-2018.
 */

public interface SendRegistrationCallback {
    void onSuccess(RegistrationDetail registrationDetail);
    void onFailure();
}
