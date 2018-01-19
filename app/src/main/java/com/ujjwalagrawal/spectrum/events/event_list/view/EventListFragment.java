package com.ujjwalagrawal.spectrum.events.event_list.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mikepenz.itemanimators.SlideDownAlphaAnimator;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.events.event_list.data.EventData;
import com.ujjwalagrawal.spectrum.events.event_list.presenter.EventListPresenter;
import com.ujjwalagrawal.spectrum.events.event_list.presenter.EventListPresenterImpl;
import com.ujjwalagrawal.spectrum.events.event_list.provider.RetrofitEventListProvider;

import java.util.List;


public class EventListFragment extends Fragment implements EventListView{
	private static final String DAY = "day";

	private int mday;
	private Context context;
	RecyclerView event_recyclerView;
	private LinearLayoutManager linearLayoutManager;

	private SwipeRefreshLayout swipeRefreshLayout;
	private EventListPresenter eventListPresenter;
	private EventsAdapter eventsAdapter;
	private ProgressBar progressBar;

	private OnFragmentInteractionListener mListener;

	public EventListFragment() {
		// Required empty public constructor
	}

	public static EventListFragment newInstance(int day) {
		EventListFragment fragment = new EventListFragment();
		Bundle args = new Bundle();
		args.putInt(DAY, day);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mday = getArguments().getInt(DAY);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =inflater.inflate(R.layout.fragment_event_list, container, false);
		progressBar=(ProgressBar)view.findViewById(R.id.events_progressbar);
		swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout_events);
		event_recyclerView = (RecyclerView) view.findViewById(R.id.event_recycler_view);
		event_recyclerView.setHasFixedSize(true);
		context = getContext();
		linearLayoutManager = new LinearLayoutManager(getContext());
		eventsAdapter = new EventsAdapter(getContext());

		eventListPresenter=new EventListPresenterImpl(this,new RetrofitEventListProvider());
		event_recyclerView.setLayoutManager(linearLayoutManager);
		event_recyclerView.setAdapter(eventsAdapter);
		event_recyclerView.setItemAnimator(new SlideDownAlphaAnimator());
		eventListPresenter.requestEventList(mday);

		swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
            eventListPresenter.requestEventList(mday);
            swipeRefreshLayout.setRefreshing(false);
			}
		});

		return view;
	}


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

	@Override
	public void SetData(List<EventData> eventDataList) {
		eventsAdapter.setData(eventDataList);
		eventsAdapter.notifyDataSetChanged();
	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
	}

	@Override
	public void ShowProgressBar(boolean show) {
		if(show) {
			progressBar.setVisibility(View.VISIBLE);
		}else {
			progressBar.setVisibility(View.INVISIBLE);
		}
	}

	public interface OnFragmentInteractionListener {
		void onFragmentInteraction(Uri uri);
	}
}
