package com.ujjwalagrawal.spectrum.profile.provider;

import com.ujjwalagrawal.spectrum.profile.RegisterListCallback;

/**
 * Created by nosta on 18-01-2018.
 */

public interface RegisterListProvider {
    void requestRegistrationList( String token, RegisterListCallback registerListCallback);
}
