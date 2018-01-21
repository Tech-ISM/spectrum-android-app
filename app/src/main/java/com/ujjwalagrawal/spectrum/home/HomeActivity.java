package com.ujjwalagrawal.spectrum.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import com.crashlytics.android.Crashlytics;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.ujjwalagrawal.spectrum.helper.fcm.FcmUtils;
import com.ujjwalagrawal.spectrum.notifications.view.NotificationListFragment;
import com.ujjwalagrawal.spectrum.R;

import com.ujjwalagrawal.spectrum.home.view.HomeFragment;

import com.ujjwalagrawal.spectrum.events.event_list.view.EventTitleListFragment;
import com.ujjwalagrawal.spectrum.helper.SharedPrefs;
import com.ujjwalagrawal.spectrum.login.view.LoginActivity;
import com.ujjwalagrawal.spectrum.profile.view.ProfileFragment;
import com.ujjwalagrawal.spectrum.teams.TeamsFragment;

//import com.ujjwalagrawal.spectrum_24.team.view.TeamFragment;


import io.fabric.sdk.android.Fabric;

public class HomeActivity extends AppCompatActivity {

    Context context;
    HomeActivity homeActivity;
    SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_home);
        context = this;
        homeActivity = this;

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(R.id.tab_home);
        ImageView imageViewNotifications = (ImageView) findViewById(R.id.imageView_notification);
        ImageView imageView_rateus = (ImageView) findViewById(R.id.imageView_rateus);

        imageView_rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog ad = new AlertDialog.Builder(context)
                    .create();
            ad.setCancelable(true);
            ad.setTitle("Rate Us!");
            ad.setMessage("We will redirect you to the Google Play store! Please give us a 5 star rating.");
            ad.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    final String appPackageName = getPackageName(); // getPackageName() from Context or SplashScheenActivity object
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                    ad.cancel();

                }
            });

            ad.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   ad.cancel();
                }
            });
            ad.show();
            }
        });
        imageViewNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new NotificationListFragment());
            }
        });

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_profile) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(getResources().getColor(R.color.md_purple_500));
                    }

                    toolbar.setBackgroundColor(getResources().getColor(R.color.md_purple_300));
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                    ProfileFragment profile = new ProfileFragment();
                    setFragment(profile);
                } else if (tabId == R.id.tab_events) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(getResources().getColor(R.color.md_light_green_700));
                    }
                    toolbar.setBackgroundColor(getResources().getColor(R.color.custom_light_green));
                    EventTitleListFragment eventTitleListFragment = new EventTitleListFragment();
                    setFragment(eventTitleListFragment);
                } else if (tabId == R.id.tab_home) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(getResources().getColor(R.color.md_blue_600));
                    }
                    toolbar.setBackgroundColor(getResources().getColor(R.color.md_blue_400));
                    HomeFragment homeFragment = new HomeFragment();
                    setFragment(homeFragment);


                } else if (tabId == R.id.tab_team) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(getResources().getColor(R.color.md_amber_A700));
                    }
                    toolbar.setBackgroundColor(getResources().getColor(R.color.md_amber_A400));
                    TeamsFragment teamFragment = new TeamsFragment();
                    setFragment(teamFragment);
                }
                else if (tabId == R.id.tab_logout) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(getResources().getColor(R.color.color_logout_tab_dark));
                    }
                    toolbar.setBackgroundColor(getResources().getColor(R.color.color_logout_tab));

//                    ChatFragment sponsorsFragment = new SponsorsFragment();
//                    setFragment(sponsorsFragment);
                    final AlertDialog ad = new AlertDialog.Builder(context)
                            .create();
                    ad.setCancelable(false);
                    ad.setTitle("Logout");
                    ad.setMessage("Do you really want to logout");
                    ad.setButton(DialogInterface.BUTTON_POSITIVE, "Logout", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ad.cancel();
                            sharedPrefs = new SharedPrefs(context);
                            sharedPrefs.setAccessToken("");
                            sharedPrefs.setMobile("");
                            sharedPrefs.setUsername("");
                            sharedPrefs.setLogin(false);
                            Intent intent = new Intent(homeActivity, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                    ad.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            ad.cancel();

                        }
                    });
                    ad.show();


                }
            }
        });

        try{
            FcmUtils fcmUtils=new FcmUtils(context);

            fcmUtils.sendFcmToServer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contentContainer, fragment);
            fragmentTransaction.commit();
        }
    }
}