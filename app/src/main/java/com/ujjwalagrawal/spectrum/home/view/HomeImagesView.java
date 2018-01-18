package com.ujjwalagrawal.spectrum.home.view;

import com.ujjwalagrawal.spectrum.home.model.HomeImageDetails;

import java.util.List;

/**
 * Created by hp-p on 17-Jan-18.
 */

public interface HomeImagesView {
    void setData(List<HomeImageDetails> HomeImagesDataList);
    void showMessage(String message);
    void showProgressBar(boolean show);
//    void openImageUrl(String url);
}
