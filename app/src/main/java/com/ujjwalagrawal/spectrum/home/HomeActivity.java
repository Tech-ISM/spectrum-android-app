package com.ujjwalagrawal.spectrum.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

//import com.ujjwalagrawal.spectrum.team.view.TeamFragment;


import io.fabric.sdk.android.Fabric;

public class HomeActivity extends AppCompatActivity {

    Context context;
    HomeActivity homeActivity;
    SharedPrefs sharedPrefs;
    private VideoView video1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_home);
        context = this;
        homeActivity = this;

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_profile) {

                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                    ProfileFragment profile = new ProfileFragment();
                    setFragment(profile);
                } else if (tabId == R.id.tab_events) {
                    EventTitleListFragment eventTitleListFragment = new EventTitleListFragment();
                    setFragment(eventTitleListFragment);
                } else if (tabId == R.id.tab_home) {
                    HomeFragment homeFragment = new HomeFragment();
                    setFragment(homeFragment);


                } else if (tabId == R.id.tab_team) {

                    TeamsFragment teamFragment = new TeamsFragment();
                    setFragment(teamFragment);
                }
                else if (tabId == R.id.tab_logout) {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_rate_us) {
            final AlertDialog ad = new AlertDialog.Builder(this)
                    .create();
            ad.setCancelable(false);
            ad.setTitle("Rate Us!");
            ad.setMessage("We will redirect you to the Google Play store! Please give us a 5 star rating.");

            ad.setButton(DialogInterface.BUTTON_NEGATIVE, "Ok", new DialogInterface.OnClickListener() {
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
            ad.show();
            return true;
        }else  if (id ==R.id.action_notifications){
            setFragment(new NotificationListFragment());
            return true;
        }

        return super.onOptionsItemSelected(item);
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