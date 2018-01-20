package com.ujjwalagrawal.spectrum.notifications.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mikepenz.itemanimators.SlideDownAlphaAnimator;
import com.ujjwalagrawal.spectrum.notifications.data.NotificationData;
import com.ujjwalagrawal.spectrum.notifications.presenter.NotificationListPresenter;
import com.ujjwalagrawal.spectrum.notifications.presenter.NotificationListPresenterImpl;
import com.ujjwalagrawal.spectrum.notifications.provider.RetrofitNotificationListProvider;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.helper.SharedPrefs;

public class NotificationListFragment extends Fragment implements NotificationListView{
	private Context context;
	RecyclerView notification_recyclerView;
	private LinearLayoutManager linearLayoutManager;

	private NotificationListPresenter notificationListPresenter;
	private NotificationRecyclerAdapter notificationRecyclerAdapter;
	private ProgressBar progressBar;
	private SharedPrefs sharedPrefs;
	public NotificationListFragment() {
		// Required empty public constructor
	}

	public static NotificationListFragment newInstance() {
		NotificationListFragment fragment = new NotificationListFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =inflater.inflate(R.layout.fragment_notification_list, container, false);
		progressBar=(ProgressBar)view.findViewById(R.id.progressBar);
		notification_recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
		notification_recyclerView.setHasFixedSize(true);
		context = getContext();
		sharedPrefs = new SharedPrefs(context);
		linearLayoutManager = new LinearLayoutManager(getContext());
		notificationRecyclerAdapter = new NotificationRecyclerAdapter(getContext());

		notificationListPresenter =new NotificationListPresenterImpl(this,new RetrofitNotificationListProvider());
		notification_recyclerView.setLayoutManager(linearLayoutManager);
		notification_recyclerView.setAdapter(notificationRecyclerAdapter);
		notification_recyclerView.setItemAnimator(new SlideDownAlphaAnimator());
		notificationListPresenter.requestNotificationList(sharedPrefs.getAccessToken());

		return view;
	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setData(NotificationData notificationData) {
		notificationRecyclerAdapter.setData(notificationData.getNotification_list());
		notificationRecyclerAdapter.notifyDataSetChanged();
	}

	@Override
	public void ShowProgressBar(boolean show) {
		if(show) {
			progressBar.setVisibility(View.VISIBLE);
		}else {
			progressBar.setVisibility(View.INVISIBLE);
		}
	}

}
