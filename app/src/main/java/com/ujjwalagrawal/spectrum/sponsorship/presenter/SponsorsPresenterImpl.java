package com.ujjwalagrawal.spectrum.sponsorship.presenter;

import android.os.CountDownTimer;

import com.ujjwalagrawal.spectrum.sponsorship.provider.SponsorsListProvider;
import com.ujjwalagrawal.spectrum.sponsorship.view.SponsorsView;

/**
 * Created by nosta on 25-10-2017.
 */

public class SponsorsPresenterImpl implements SponsorsPresenter {
    private SponsorsView sponsorsView;
    private SponsorsListProvider sponsorsListProvider;
    CountDownTimer countDownTimer;

    public SponsorsPresenterImpl(SponsorsView sponsorsView, SponsorsListProvider sponsorsListProvider) {
        this.sponsorsView = sponsorsView;
        this.sponsorsListProvider = sponsorsListProvider;
    }

    @Override
    public void requestSponsorList() {
        sponsorsView.showProgressBar(True);

        countDownTimer = new CountDownTimer(8000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                eventListView.showMessage( "Slow internet connection..");
            }
        }.start();
    }
}
