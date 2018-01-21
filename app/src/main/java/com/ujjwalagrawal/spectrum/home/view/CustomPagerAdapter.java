package com.ujjwalagrawal.spectrum.home.view;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.helper.image_loaders.ImageLoader;
//import com.ujjwalagrawal.spectrum_24.home.model.HomeImageDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp-p on 17-Jan-18.
 */

public class CustomPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment_homePager> fragments;

    public CustomPagerAdapter(FragmentManager fm,List<Fragment_homePager> data) {
        super(fm);
        this.fragments=data;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void reset(){
        for(Fragment_homePager f: fragments){
            f.reset();
        }
    }
}
