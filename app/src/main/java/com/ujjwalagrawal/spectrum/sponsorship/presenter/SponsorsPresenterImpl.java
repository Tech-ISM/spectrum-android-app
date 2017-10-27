package com.ujjwalagrawal.spectrum.sponsorship.presenter;

import android.os.CountDownTimer;

import com.ujjwalagrawal.spectrum.sponsorship.SponsorshipCallback;
import com.ujjwalagrawal.spectrum.sponsorship.model.SponsorshipResponse;
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
        sponsorsView.showProgressBar(true);

        countDownTimer = new CountDownTimer(8000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                sponsorsView.showMessage( "Slow internet connection..");
            }
        }.start();
        sponsorsListProvider.RequestSponsorsList(new SponsorshipCallback() {
			@Override
			public void onSponsorshipSuccess(SponsorshipResponse sponsorshipResponse) {
				sponsorsView.showProgressBar(false);
				if (sponsorshipResponse.isSuccess()){
					sponsorsView.setData(sponsorshipResponse.getSponsorsDetailsList());
				}else {
					sponsorsView.showMessage(sponsorshipResponse.getMessage());
				}
			}

			@Override
			public void onSponsorshipFailure(String error) {
				sponsorsView.showProgressBar(false);
				sponsorsView.showMessage("Unable to connect to server ");
			}
		});
    }
}
