package com.ujjwalagrawal.spectrum.profile.view;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ujjwalagrawal.spectrum.R;

import static com.ujjwalagrawal.spectrum.R.id.tabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    MyAdapter madapter;
    ViewPager mpager;
    TabLayout tabLayout;
    Toolbar toolbar;



    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_profile, container, false);
        madapter=new MyAdapter(getChildFragmentManager());
        mpager=(ViewPager)view.findViewById(R.id.viewPager);
        toolbar=(Toolbar)view.findViewById(R.id.toolbar);

        mpager.setAdapter(madapter);
        tabLayout=(TabLayout)view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mpager);


        return view;

        // Inflate the layout for  fragment
    }

    public static class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new YouFragment();
                case 1:
                    return new SingleFragment();
                case 2:
                    return new MultipleFragment();

            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0:
                    return "You";
                case 1:
                    return "Single participant";
                case 2:
                    return "Multiple Participant";

            }
            return null;
        }
    }
}

