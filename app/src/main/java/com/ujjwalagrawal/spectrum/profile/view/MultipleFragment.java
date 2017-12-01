package com.ujjwalagrawal.spectrum.profile.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ujjwalagrawal.spectrum.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultipleFragment extends Fragment {


    public MultipleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_multiple, container, false);
    }

}
