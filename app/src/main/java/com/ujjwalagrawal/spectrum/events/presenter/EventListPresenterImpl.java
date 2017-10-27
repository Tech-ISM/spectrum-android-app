package com.ujjwalagrawal.spectrum.events.presenter;

import android.os.CountDownTimer;

import com.ujjwalagrawal.spectrum.events.EventListCallback;
import com.ujjwalagrawal.spectrum.events.data.EventList;
import com.ujjwalagrawal.spectrum.events.provider.EventListProvider;
import com.ujjwalagrawal.spectrum.events.view.EventListView;

/**
 * Created by ujjwal on 25/10/17.
 */

public class EventListPresenterImpl implements EventListPresenter{
	private EventListView eventListView;
	private EventListProvider eventListProvider;
	CountDownTimer countDownTimer;

	public EventListPresenterImpl(EventListView eventListView, EventListProvider eventListProvider) {
		this.eventListView = eventListView;
		this.eventListProvider = eventListProvider;
	}

	@Override
	public void requestEventList(int day) {
		eventListView.ShowProgressBar(true);

//		countDownTimer = new CountDownTimer(8000, 1000) {
//			public void onTick(long millisUntilFinished) {
//			}
//
//			public void onFinish() {
//				eventListView.showMessage( "Slow internet connection..");
//			}
//		}.start();

		eventListProvider.requestEventList(day,new EventListCallback() {
			@Override
			public void onSuccess(EventList eventList) {
				eventListView.ShowProgressBar(false);
				if (eventList.isSuccess()){
					eventListView.SetData(eventList.getEvent_list());
				}else {
					eventListView.showMessage("Unable to connect to server ..");
				}
			}

			@Override
			public void onFailure() {
				eventListView.ShowProgressBar(false);
				eventListView.showMessage("Unable to connect to server ..");
			}
		});
	}
}
