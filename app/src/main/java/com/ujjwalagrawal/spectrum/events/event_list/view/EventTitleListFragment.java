package com.ujjwalagrawal.spectrum.events.event_list.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ujjwalagrawal.spectrum.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventTitleListFragment extends Fragment {


	@BindView(R.id.viewPager)
	ViewPager viewPager;

	@BindView(R.id.tabLayout)
	TabLayout tabLayout;

	@BindView(R.id.progressBar)
	ProgressBar progressBar;

	private ViewPagerAdapter viewPagerAdapter;

	private OnFragmentInteractionListener mListener;

	public static EventTitleListFragment newInstance(String param1, String param2) {
		EventTitleListFragment fragment = new EventTitleListFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =inflater.inflate(R.layout.fragment_event_title_list, container, false);
		ButterKnife.bind(this,view);

		viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
		viewPager.setAdapter(viewPagerAdapter);
		tabLayout.setupWithViewPager(viewPager);

		List<Fragment> fragmentList = new ArrayList<>();
		List<String> titleList = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			EventListFragment fragment = EventListFragment.newInstance(i);
			fragmentList.add(fragment);
			titleList.add("DAY "+i );
		}

		viewPagerAdapter.setTabData(fragmentList, titleList);
		viewPagerAdapter.notifyDataSetChanged();

		return view;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
}
