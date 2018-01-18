package com.ujjwalagrawal.spectrum.profile;


import com.ujjwalagrawal.spectrum.profile.model.RegistrationList;

/**
 * Created by nosta on 18-01-2018.
 */

public interface RegisterListCallback {
    void onSuccess(RegistrationList registrationList);
    void onFailure();
}
