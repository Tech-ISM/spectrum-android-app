package com.ujjwalagrawal.spectrum.profile.provider;

import com.ujjwalagrawal.spectrum.profile.RegisterListCallback;
import com.ujjwalagrawal.spectrum.profile.SendRegistrationCallback;

/**
 * Created by nosta on 18-01-2018.
 */

public interface RegisterListProvider {
    void requestRegistrationList( String token, RegisterListCallback registerListCallback);
    void sendRegistrationData(int id, int participated, String token , SendRegistrationCallback sendRegistrationCallback);
}
