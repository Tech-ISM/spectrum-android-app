package com.ujjwalagrawal.spectrum.events.view;


import com.ujjwalagrawal.spectrum.events.data.EventData;

import java.util.List;

/**
 * Created by ujjwal on 25/10/17.
 */

public interface EventListView {
	void SetData(List<EventData> eventDataList);
	void showMessage(String message);
	void ShowProgressBar(boolean show);
}
