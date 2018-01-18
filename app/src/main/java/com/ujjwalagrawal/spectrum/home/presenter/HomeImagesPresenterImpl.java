package com.ujjwalagrawal.spectrum.home.presenter;

import android.os.CountDownTimer;

import com.ujjwalagrawal.spectrum.home.HomeImagesCallback;
import com.ujjwalagrawal.spectrum.home.model.HomeImageResponse;
import com.ujjwalagrawal.spectrum.home.provider.HomeImageListProvider;
import com.ujjwalagrawal.spectrum.home.view.HomeImagesView;

/**
 * Created by hp-p on 17-Jan-18.
 */

public class HomeImagesPresenterImpl implements HomeImagesPresenter {
    private HomeImagesView homeImagesView;
    private HomeImageListProvider homeImageListProvider;
    private CountDownTimer countDownTimer;

    public HomeImagesPresenterImpl(HomeImagesView homeImagesView, HomeImageListProvider homeImageListProvider) {
        this.homeImagesView = homeImagesView;
        this.homeImageListProvider = homeImageListProvider;
    }

    @Override
    public void requestHomeImagesList() {
        homeImagesView.showProgressBar(true);

        countDownTimer = new CountDownTimer(8000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                homeImagesView.showMessage( "Slow internet connection..");
            }
        }.start();
        homeImageListProvider.RequestHomeImagesList(new HomeImagesCallback() {
            @Override
            public void onHomeImageSuccess(HomeImageResponse homeImageResponse) {
                homeImagesView.showProgressBar(false);
                if (homeImageResponse.isSuccess()){
                    homeImagesView.setData(homeImageResponse.getHomeImageDetailsList());
                }else {
                    homeImagesView.showMessage(homeImageResponse.getMessage());
                }
            }

            @Override
            public void onHomeImageFailure(String error) {
                homeImagesView.showProgressBar(false);
                homeImagesView.showMessage("Unable to connect to server ");
            }
        });
    }
}
