package com.ujjwalagrawal.spectrum.home.view;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.helper.utils.AutoScrollViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

	@BindView(R.id.about)
	TextView about;
	@BindView(R.id.b1)
	TextView b1;
	@BindView(R.id.b2)
	TextView b2;
	@BindView(R.id.viewPager)
	AutoScrollViewPager viewPager;
	CustomPagerAdapter adapter;
	int[] data;
	Timer swipeTimer;
	int currentPage=0;
	SwishyTransformer transformer;
	List<Fragment_homePager> data_images;


	public HomeFragment() {
		// Required empty public constructor
	}
	public static HomeFragment newInstance() {

		Bundle args = new Bundle();

		HomeFragment fragment = new HomeFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		final View view =inflater.inflate(R.layout.fragment_home, container, false);
		ButterKnife.bind(this,view);

		assignViews(view);
		set_images();
		init(data_images);
//		time_pager(viewPager);
		set_about_tabs(view);

		return view;
	}

	public void init(List<Fragment_homePager> data_images)
	{
		transformer = new SwishyTransformer();
		adapter= new CustomPagerAdapter(getActivity().getSupportFragmentManager(),data_images);
		viewPager.setAdapter(adapter);
		viewPager.setPageTransformer(true, transformer);;
		viewPager.startAutoScroll(1000);
		viewPager.setAutoScrollDurationFactor(15);

//		viewPager.setOnClickListener(new View.OnClickListener() {
//				@Override
//				public void onClick(View v)
//				{
//					Intent browserIntent = new Intent(Intent.ACTION_VIEW);
//				    browserIntent.setData(Uri.parse("www.facebook.com/spectrum.iitism/"));
//				    getContext().startActivity(browserIntent);
//				}
//			});

	}

	public void set_images(){
		data_images = new ArrayList<>();
		data_images.add(Fragment_homePager.newInstance(R.drawable.all_events));
		data_images.add(Fragment_homePager.newInstance(R.drawable.circuit_debugging));
		data_images.add(Fragment_homePager.newInstance(R.drawable.triathlon));
		data_images.add(Fragment_homePager.newInstance(R.drawable.robosoccer));

		data_images.add(Fragment_homePager.newInstance(R.drawable.cs_go));
	}

	public void assignViews(View view)
	{
		data=new int[]{R.drawable.framelayout1,R.drawable.framelayout3};
		viewPager=(AutoScrollViewPager) view.findViewById(R.id.viewPager);
	}

	public void set_about_tabs(View view)
	{
		set_tab(false);
		Button abt_spectrum=(Button)view.findViewById(R.id.abt_spectrum);
		abt_spectrum.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				set_tab(false);

			}
		});
		Button abt_see=(Button)view.findViewById(R.id.abt_see);
		abt_see.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				set_tab(true);
			}
		});
	}

	public void set_tab(boolean tab)
	{
		if (tab)
		{
			about.setText(R.string.about_SEE);
			b1.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
			b2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
		}
		else
		{
			about.setText(R.string.about_spectrum);
			b2.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
			b1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
		}

	}

	@Override
	public void onResume() {
		super.onResume();

	}


	@Override
	public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
		super.onViewStateRestored(savedInstanceState);
	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		if(!hidden){
			final Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {

					for(int i=0;i<viewPager.getChildCount();i++){
						View v = viewPager.getChildAt(i);
						v.setTranslationX(0);
						v.setTranslationY(0);
						v.setVisibility(View.VISIBLE);
					}
				}
			}, 400);
		}
	}

}
