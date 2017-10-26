package com.ujjwalagrawal.spectrum.sponsorship.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.sponsorship.presenter.SponsorsPresenterImpl;


/**
 * A simple {@link Fragment} subclass.
 */
public class SponsorsFragment extends Fragment {


    public SponsorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView detailsRecycler = (RecyclerView) inflater.inflate(R.layout.sponsor_details, container, false);


        int namelength = SponsorsPresenterImpl.companyNamelength();
        String[] companyname = new String[namelength];
        for (int i = 0; i < namelength; i++) {
            companyname[i] = SponsorsPresenterImpl.getCompanyName(i);
        }

        String phoneno = new String[namelength];
        for (int i = 0; i < namelength; i++) {
            phoneno[i] = SponsorsPresenterImpl.getPhoneNo(i);
        }

        String imageurl = new String[namelength];
        for (int i = 0; i < namelength; i++) {
            imageurl[i] = SponsorsPresenterImpl.getImageUrl(i)
        }

        SponsorsAdapter adapter = new SponsorsAdapter(companyname, phoneno, imageurl);
        detailsRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        detailsRecycler.setLayoutManager(layoutManager);
        return detailsRecycler;

    }
}
