package com.ujjwalagrawal.spectrum.sponsorship.view;

import com.ujjwalagrawal.spectrum.sponsorship.model.SponsorsDetails;

import java.util.List;

/**
 * Created by nosta on 27-10-2017.
 */

public interface SponsorsView {
    void setData(List<SponsorsDetails> eventDataList);
    void showMessage(String message);
    void showProgressBar(boolean show);
//    void openImageUrl(String url);
}
