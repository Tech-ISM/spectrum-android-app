package com.ujjwalagrawal.spectrum.events.event_details.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RulesFragment extends Fragment {

    @BindView(R.id.description_textview)
    TextView rulesTextView;

    String rules = "";


    public RulesFragment() {
        // Required empty public constructor
    }


    public static RulesFragment newInstance() {
        RulesFragment fragment = new RulesFragment();
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
        View view= inflater.inflate(R.layout.fragment_rules, container, false);
        ButterKnife.bind(this, view);
        rulesTextView.setText(rules);

        return view;
    }

    public void setRules(String rules) {
        this.rules = rules;
        if(rulesTextView !=null) {
            rulesTextView.setText(rules);
        }

    }
}
