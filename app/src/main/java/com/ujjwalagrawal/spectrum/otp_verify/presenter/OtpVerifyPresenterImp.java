package com.ujjwalagrawal.spectrum.otp_verify.presenter;


import com.ujjwalagrawal.spectrum.otp_verify.OtpVerificationCallback;
import com.ujjwalagrawal.spectrum.otp_verify.model.OtpResponse;
import com.ujjwalagrawal.spectrum.otp_verify.provider.OtpVerifyHelperClass;
import com.ujjwalagrawal.spectrum.otp_verify.view.OtpView;

/**
 * Created by ujjwal on 24/10/17.
 */

public class OtpVerifyPresenterImp implements OtpVerifyPresenter{

    private OtpView otpView;
    private OtpVerifyHelperClass otpVerifyHelperClass;

    public OtpVerifyPresenterImp(OtpView otpView, OtpVerifyHelperClass otpVerifyHelperClass) {
        this.otpView = otpView;
        this.otpVerifyHelperClass = otpVerifyHelperClass;
    }

    @Override
    public void getOtpResponse(final String otp, String mobile, String access_token) {
        otpView.showProgressBar(true);
        otpVerifyHelperClass.getOtpResponse(otp, mobile,access_token,new OtpVerificationCallback() {
            @Override
            public void onOtpVerified(OtpResponse otpResponse) {

                if (otpResponse.isSuccess()) {
                    otpView.OtpStatus(otpResponse);

                } else {
                    otpView.showMessage(otpResponse.getMessage());
                    otpView.verifyBtnClickable();
                }
                otpView.showProgressBar(false);
            }

            @Override
            public void onFailure(String error) {
                otpView.showProgressBar(false);
                otpView.showMessage("Sorry!!Something went wrong");
                otpView.checkNetwork();
            }
        });

    }

    @Override
    public void onDestroy() {
        if(otpVerifyHelperClass!=null){
            otpVerifyHelperClass.onDestroy();
        }
    }
}
