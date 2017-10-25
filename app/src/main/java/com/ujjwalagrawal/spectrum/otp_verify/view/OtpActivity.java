package com.ujjwalagrawal.spectrum.otp_verify.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ujjwalagrawal.spectrum.home.HomeActivity;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.helper.Keys;
import com.ujjwalagrawal.spectrum.helper.NetworkUtils;
import com.ujjwalagrawal.spectrum.helper.SharedPrefs;
import com.ujjwalagrawal.spectrum.login.data.LoginResponse;
import com.ujjwalagrawal.spectrum.login.presenter.LoginPresenter;
import com.ujjwalagrawal.spectrum.login.presenter.LoginPresenterImpl;
import com.ujjwalagrawal.spectrum.login.provider.RetrofitLoginHelper;
import com.ujjwalagrawal.spectrum.login.view.LoginView;
import com.ujjwalagrawal.spectrum.otp_verify.model.OtpResponse;
import com.ujjwalagrawal.spectrum.otp_verify.presenter.OtpVerifyPresenter;
import com.ujjwalagrawal.spectrum.otp_verify.presenter.OtpVerifyPresenterImp;
import com.ujjwalagrawal.spectrum.otp_verify.provider.RetrofitOtpVerifyHelper;

import butterknife.ButterKnife;

public class OtpActivity extends AppCompatActivity implements OtpView{


    private Button btn_resend_otp,btn_verify_otp,btn_login;
    private TextView otp_message;
    private EditText editTextOtp,editTextMobile,editTextName,editTextEmail;
    private ProgressBar progressBar;
    private ImageView otpImage,login_bg;
    private String message, otp_number;
    private OtpVerifyPresenter otpVerifyPresenter;
    private SharedPrefs sharedPrefs;
    private LinearLayout otp_verify_layout;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //Glide.with(this).load(R.drawable.password_black).into(oi);

        sharedPrefs = new SharedPrefs(this);
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            message = bundle.getString(Keys.KEY_MOBILE);
        }
        btn_login = (Button) findViewById(R.id.logIn);
        btn_verify_otp = (Button) findViewById(R.id.btnVerify);
        editTextMobile = (EditText) findViewById(R.id.input_mobile);
        editTextName = (EditText) findViewById(R.id.input_name);
        editTextEmail = (EditText) findViewById(R.id.input_email);
        login_bg = (ImageView) findViewById(R.id.login_background);
        editTextOtp = (EditText) findViewById(R.id.input_otp);
        btn_resend_otp = (Button) findViewById(R.id.resend_otp);
        otpImage = (ImageView) findViewById(R.id.otp_img);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        otp_message = (TextView) findViewById(R.id.otp_msg);
        otp_verify_layout =(LinearLayout) findViewById(R.id.otp_verifyLayout);

        editTextName.setVisibility(View.GONE);
        editTextMobile.setVisibility(View.GONE);
        editTextEmail.setVisibility(View.GONE);
        btn_login.setVisibility(View.GONE);
        otp_verify_layout.setVisibility(View.VISIBLE);
        otpImage.setVisibility(View.VISIBLE);
        otp_message.setVisibility(View.VISIBLE);
        btn_resend_otp.setVisibility(View.VISIBLE);
        btn_verify_otp.setVisibility(View.VISIBLE);
    }

    public void proceed_verify(View v) {
        otp_number = editTextOtp.getText().toString();
        btn_verify_otp.setClickable(false);
        if (otp_number.isEmpty()){
            Toast.makeText(this,"This field cannot be empty!",Toast.LENGTH_SHORT).show();
            btn_verify_otp.setClickable(true);
        }
        else {
            otpVerifyPresenter = new OtpVerifyPresenterImp(this, new RetrofitOtpVerifyHelper());
            otpVerifyPresenter.getOtpResponse(otp_number, message,sharedPrefs.getAccessToken());
        }

    }
    public void resend(View v) {
        btn_resend_otp.setVisibility(View.GONE);
       /* LoginActivity loginActivity = new LoginActivity();
        loginActivity.proceed(v);
        */
        LoginPresenter loginData = new LoginPresenterImpl(new LoginView() {
            @Override
            public void showProgressBar(boolean show) {

            }

            @Override
            public void showLoginStatus(LoginResponse loginDataResponse) {

            }

            @Override
            public void showError(String message) {

            }

            @Override
            public void checkNetwork() {

            }
        }, new RetrofitLoginHelper());
        loginData.getLoginData(sharedPrefs.getUsername(),sharedPrefs.getMobile(),sharedPrefs.getEmail());
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btn_resend_otp.setVisibility(View.VISIBLE);
            }
        },30000);


    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void OtpStatus(OtpResponse otpResponse) {
        Intent i = new Intent(this, HomeActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        sharedPrefs.setLogin(true);
        finish();
    }

    @Override
    public void checkNetwork() {
        if(!NetworkUtils.isNetworkAvailable(this)){
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.activity_rules__dialog_box);
            Button btn = (Button) dialog.findViewById(R.id.dialog_button);
            TextView rules5 = (TextView) dialog.findViewById(R.id.rules5);
            btn.setText("Retry");
            rules5.setText("No internet connection.Please try again.");
            dialog.setTitle("Connectivity Failed");
            dialog.setCancelable(false);
            dialog.show();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    otpVerifyPresenter = new OtpVerifyPresenterImp(OtpActivity.this, new RetrofitOtpVerifyHelper());
                    otpVerifyPresenter.getOtpResponse(otp_number, message,sharedPrefs.getAccessToken());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void verifyBtnClickable() {
        btn_verify_otp.setClickable(true);
    }

    @Override
    protected void onDestroy() {
        if(otpVerifyPresenter!=null){
            otpVerifyPresenter.onDestroy();
        }
        super.onDestroy();

    }
}
