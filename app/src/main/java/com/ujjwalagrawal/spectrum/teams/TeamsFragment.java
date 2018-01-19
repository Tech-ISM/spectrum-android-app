package com.ujjwalagrawal.spectrum.teams;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ujjwalagrawal.spectrum.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hp-p on 28-Oct-17.
 */

public class TeamsFragment extends Fragment {
    private List<team_members> developers;
    private List<team_members> organizers;
    private List<team_members> head_members;
    private  RecyclerView            developers_Recyclerview ,   organizers_Recyclerview, head_Recyclerview   ;
    private  RecyclerView.Adapter    developerAdapter        ,   organizerAdapter       , headAdapter  ;

    public TeamsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_teams, container, false); // Inflate the layout for this fragment

        developers=new ArrayList<>();
        organizers=new ArrayList<>();
        head_members=new ArrayList<>();

        put_data();
        set_adapters(view);

        return view;
    }

    public void set_adapters(View view)
    {
        head_Recyclerview = (RecyclerView) view.findViewById(R.id.head_members_recyclerview);
        head_Recyclerview.setHasFixedSize(true);
        head_Recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        headAdapter = new TeamsAdapter(head_members, getContext(),false);

        developers_Recyclerview = (RecyclerView) view.findViewById(R.id.developer_recycler_view);
        developers_Recyclerview.setHasFixedSize(true);
        developers_Recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        developerAdapter = new TeamsAdapter(developers, getContext(),true);

        organizers_Recyclerview = (RecyclerView) view.findViewById(R.id.organizers_recycler_view);
        organizers_Recyclerview.setHasFixedSize(true);
        organizers_Recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        organizerAdapter = new TeamsAdapter(organizers, getContext(),false);

        developers_Recyclerview.setAdapter(developerAdapter);
        organizers_Recyclerview.setAdapter(organizerAdapter);
        head_Recyclerview.setAdapter(headAdapter);

    }

    public void put_data()//will be used to set data finally
    {
        developers.add(new team_members("Akhil Vaidya","Developer",R.drawable.mem_akhil,"8578955444","https://github.com/avstark"));
        organizers.add(new team_members("sanskar Shrivastava","organizers",R.drawable.framelayout1,"23456s343","https://www.facebook.com/profile.php?id=100000383742195&ref=br_rs"));
        head_members.add(new team_members("Aman Gupta","junior developer",R.drawable.framelayout3,"234563434553346","https://github.com/Tech-ISM/spectrum-android-app"));
    }



}
