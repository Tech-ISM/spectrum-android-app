package com.ujjwalagrawal.spectrum.profile.presenter;

import com.ujjwalagrawal.spectrum.profile.RegisterListCallback;
import com.ujjwalagrawal.spectrum.profile.SendRegistrationCallback;
import com.ujjwalagrawal.spectrum.profile.model.RegistrationDetail;
import com.ujjwalagrawal.spectrum.profile.model.RegistrationList;
import com.ujjwalagrawal.spectrum.profile.provider.RegisterListProvider;
import com.ujjwalagrawal.spectrum.profile.view.RegisterListView;

/**
 * Created by nosta on 18-01-2018.
 */

public class RegisterListPresenterImpl implements RegisterListPresenter{
    private RegisterListView registerListView;
    private RegisterListProvider registerListProvider;


    public RegisterListPresenterImpl(RegisterListView registerListView, RegisterListProvider registerListProvider) {
        this.registerListView = registerListView;
        this.registerListProvider = registerListProvider;
    }

    @Override
    public void requestRegistrationList(String token, final int type) {
        registerListProvider.requestRegistrationList(token, new RegisterListCallback() {
            @Override
            public void onSuccess(RegistrationList registrationList) {
                if(registrationList.isSuccess()){
                    registerListView.SetData(registrationList.getEvent_list(),type);
                } else {
                    registerListView.showMessage("Unable to connect to the server...");
                }
            }

            @Override
            public void onFailure() {
                registerListView.showMessage("Unable to connect to the server...");

            }
        });

    }

    @Override
    public void sendRegistrationData(int id, int type, int participated, String token) {
        registerListProvider.sendRegistrationData(id, type, participated, token, new SendRegistrationCallback() {
            @Override
            public void onSuccess(RegistrationDetail registrationDetail) {
                if(registrationDetail.isSuccess()){
                    registerListView.onParticipatedStatusUpdated();
                } else {
                    registerListView.showMessage(registrationDetail.getMessage());
                }
            }

            @Override
            public void onFailure() {
                registerListView.showMessage("Unable to register you to this event...");
            }
        });
    }
}
