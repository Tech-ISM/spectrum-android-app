package com.ujjwalagrawal.spectrum.home;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.events.view.EventTitleListFragment;

import io.fabric.sdk.android.Fabric;

public class HomeActivity extends AppCompatActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link FragmentPagerAdapter} derivative, which will keep every
	 * loaded fragment in memory. If this becomes too memory intensive, it
	 * may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Fabric.with(this, new Crashlytics());
		setContentView(R.layout.activity_home);
		BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
		bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
			@Override
			public void onTabSelected(@IdRes int tabId) {
				if (tabId == R.id.tab_profile) {

					// The tab with id R.id.tab_favorites was selected,
					// change your content accordingly.
				}
				else if (tabId == R.id.tab_events){
					EventTitleListFragment eventTitleListFragment = new EventTitleListFragment();
					setFragment(eventTitleListFragment);
				}
				else if (tabId == R.id.tab_home){
					HomeFragment homeFragment = new HomeFragment();
					setFragment(homeFragment);

				}
				else if (tabId == R.id.tab_sponsors){


				}
				else if (tabId == R.id.tab_aboutus){


				}

			}
		});
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
