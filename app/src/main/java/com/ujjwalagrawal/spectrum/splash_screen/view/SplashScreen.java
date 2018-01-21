package com.ujjwalagrawal.spectrum.splash_screen.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ujjwalagrawal.spectrum.BuildConfig;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.helper.MyApplication;
import com.ujjwalagrawal.spectrum.helper.SharedPrefs;
import com.ujjwalagrawal.spectrum.home.HomeActivity;
import com.ujjwalagrawal.spectrum.login.view.LoginActivity;
import com.ujjwalagrawal.spectrum.splash_screen.model.RetrofitSplashScreenProvider;
import com.ujjwalagrawal.spectrum.splash_screen.model.data.SplashScreenData;
import com.ujjwalagrawal.spectrum.splash_screen.presenter.SplashScreenPresenter;
import com.ujjwalagrawal.spectrum.splash_screen.presenter.SplashScreenPresenterImpl;


public class SplashScreen extends Activity implements  SplashScreenView{

    SharedPrefs sharedPrefs;
    ProgressBar progressBar,
            splashProgressBar;
    SplashScreenPresenter splashScreenPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPrefs = new SharedPrefs(this);
        splashProgressBar=(ProgressBar)findViewById(R.id.splash_progress_bar);
        Log.d("Splash sceen",""+MyApplication.fcm_token);
        splashScreenPresenter = new SplashScreenPresenterImpl(this, new RetrofitSplashScreenProvider());
        splashScreenPresenter.insertFcm(MyApplication.fcm_token,sharedPrefs.getAccessToken());
    //    splashScreenPresenter.insertFcm(MyApplication.fcm_token,sharedPrefs.getAccessToken());

    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(SplashScreen.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fcmInsertStatus(final SplashScreenData splashScreenData) {

        float i = splashScreenData.getVersion();
        Log.d("log",""+ BuildConfig.VERSION_CODE);
        if (i > BuildConfig.VERSION_CODE) {
            final Dialog dialog = new Dialog(SplashScreen.this);
            dialog.setContentView(R.layout.activity_rules__dialog_box);
            Button btn = (Button) dialog.findViewById(R.id.dialog_button);
            progressBar = (ProgressBar) dialog.findViewById(R.id.progress_bar_dialog);
            TextView rules = (TextView) dialog.findViewById(R.id.rules5);

            rules.setText("Please Update the app for Better experience");
            dialog.setCancelable(false);
            dialog.setTitle("App Update");
            btn.setText("Update");
            dialog.show();

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(splashScreenData.getUrl())));

                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    }
                }
            });
        }
        else if (splashScreenData.isSuccess()) {
            sharedPrefs.setFCM(MyApplication.fcm_token);

            if (sharedPrefs.isLoggedIn()) {
                Intent in = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(in);
                finish();
            } else {
                Intent signIn = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(signIn);
                finish();
            }

        }
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            splashProgressBar.setVisibility(View.VISIBLE);
        } else {
            splashProgressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showDialog(String s) {
        try {
            final AlertDialog ad = new AlertDialog.Builder(this)
                    .create();
            ad.setCancelable(false);
            ad.setTitle("No Internet Connection");
            ad.setMessage("Please connect to internet to use our app");
            ad.setButton(DialogInterface.BUTTON_POSITIVE, "Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    splashScreenPresenter.insertFcm("fcm", sharedPrefs.getAccessToken());
                }
            });
            ad.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


