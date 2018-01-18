package com.ujjwalagrawal.spectrum.home;


import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class  HomeFragment extends Fragment {

	@BindView(R.id.about)
	TextView about;
	@BindView(R.id.b1)
	TextView b1;
	@BindView(R.id.b2)
	TextView b2;

	public HomeFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =inflater.inflate(R.layout.fragment_home, container, false);
		ButterKnife.bind(this,view);

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

		return view;
	}
	public void set_tab(boolean tab)
	{
		if (tab)
		{
			about.setText(R.string.about_spectrum);
			b1.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
			b2.setBackgroundColor(getResources().getColor(R.color.md_light_green_900));
		}
		else
		{
			about.setText(R.string.about_SEE);
			b2.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
			b1.setBackgroundColor(getResources().getColor(R.color.md_light_green_900));
		}

	}


}
