package com.ujjwalagrawal.spectrum.events.event_details.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mikepenz.itemanimators.SlideDownAlphaAnimator;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.events.event_details.data.OrganiserDetails;

import java.util.ArrayList;
import java.util.List;

public class OrganiserFragment extends Fragment {

    List<OrganiserDetails> organiserDetailsList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

    RecyclerView recyclerView;

    OrganisersAdapter organisersAdapter;
    public OrganiserFragment() {
        // Required empty public constructor
    }

    public static OrganiserFragment newInstance() {
        OrganiserFragment fragment = new OrganiserFragment();
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
        // Inflate the layout for this fragmentX
        View view=inflater.inflate(R.layout.fragment_organiser, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        linearLayoutManager = new LinearLayoutManager(getContext());
        organisersAdapter = new OrganisersAdapter(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(organisersAdapter);
        recyclerView.setItemAnimator(new SlideDownAlphaAnimator());
        organisersAdapter.setData(organiserDetailsList);
        organisersAdapter.notifyDataSetChanged();
        return view;
    }

    public void setData(List<OrganiserDetails> oragniser_list){
        this.organiserDetailsList=oragniser_list;
        if (organisersAdapter!=null){
        organisersAdapter.setData(oragniser_list);
        organisersAdapter.notifyDataSetChanged();
        }
    }
}
