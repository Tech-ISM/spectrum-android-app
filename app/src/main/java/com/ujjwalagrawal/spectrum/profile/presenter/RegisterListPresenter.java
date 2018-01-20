package com.ujjwalagrawal.spectrum.profile.presenter;

/**
 * Created by nosta on 18-01-2018.
 */

public interface RegisterListPresenter {
    void requestRegistrationList(String token,int type);
    void sendRegistrationData(int id, int participated, String token);
}
