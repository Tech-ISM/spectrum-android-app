package com.ujjwalagrawal.spectrum.events.event_details.view.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.events.event_details.data.OrganiserDetails;
import com.ujjwalagrawal.spectrum.events.event_details.view.EventDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AtendeeFragment extends Fragment {

    @BindView(R.id.atendee_textview)
    TextView atendee_textview;

    @BindView(R.id.prize_description_textview)
    TextView prize_description_textview;

    String atendee = "";
    String prize_description = "";


    public AtendeeFragment() {
    }

    public static AtendeeFragment newInstance() {

        Bundle args = new Bundle();

        AtendeeFragment fragment = new AtendeeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atendee, container, false);
        ButterKnife.bind(this, view);


        atendee_textview.setText(atendee);
        prize_description_textview.setText(prize_description);
        return view;
    }

    public void setAtendee(final String atendee, final String prize_description) {
        this.atendee = atendee;
        this.prize_description = prize_description;
        if (atendee_textview!=null){
            atendee_textview.setText(atendee);
            prize_description_textview.setText(prize_description);
        }
    }
}
