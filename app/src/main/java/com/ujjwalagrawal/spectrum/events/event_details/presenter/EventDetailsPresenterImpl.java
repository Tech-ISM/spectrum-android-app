package com.ujjwalagrawal.spectrum.events.event_details.presenter;

import com.ujjwalagrawal.spectrum.events.event_details.EventDetailsCallback;
import com.ujjwalagrawal.spectrum.events.event_details.data.EventDetails;
import com.ujjwalagrawal.spectrum.events.event_details.provider.EventDetailsProvider;
import com.ujjwalagrawal.spectrum.events.event_details.view.EventDetailsView;

public class EventDetailsPresenterImpl implements EventDetailsPresenter {
    private EventDetailsView eventDetailsView;
    private EventDetailsProvider eventDetailsProvider;

    public EventDetailsPresenterImpl(EventDetailsView eventDetailsView, EventDetailsProvider eventDetailsProvider) {
        this.eventDetailsView = eventDetailsView;
        this.eventDetailsProvider = eventDetailsProvider;
    }

    @Override
    public void getEventDetails(int event_id) {
        eventDetailsView.showProgressbar(true);
        eventDetailsProvider.getEventDetails(event_id, new EventDetailsCallback() {
            @Override
            public void onFailed() {
                eventDetailsView.showProgressbar(false);
                eventDetailsView.showMessage("Unable to Connect to Server");
            }

            @Override
            public void onSuccess(EventDetails eventDetails) {
                eventDetailsView.showProgressbar(false);
                if (eventDetails.isSuccess()){
                    eventDetailsView.setEventDetails(eventDetails);
                }else {
                    eventDetailsView.showMessage(eventDetails.getMessage());
                }
            }
        });
    }
}
