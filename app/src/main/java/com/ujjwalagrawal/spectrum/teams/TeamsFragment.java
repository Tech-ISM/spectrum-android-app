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
    private  RecyclerView            developers_Recyclerview ,   head_Recyclerview   ;
    private  RecyclerView.Adapter    developerAdapter        ,   headAdapter  ;

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

        developers_Recyclerview.setAdapter(developerAdapter);
        head_Recyclerview.setAdapter(headAdapter);

    }

    public void put_data()//will be used to set data finally
    {
        developers.add(new team_members("Ujjwal Agrawal","App Developer",R.drawable.ujjwal_agrawal,"8770776846","https://github.com/ujjwalagrawal17"));
        developers.add(new team_members("Shubham Raj","App Developer",R.drawable.shubham_raj,"7277774644","https://github.com/hacker5210"));
        developers.add(new team_members("Akhil Vaidya","App Developer",R.drawable.akhil_vaidya,"8578955444","https://github.com/avstark"));
        developers.add(new team_members("Aman Gupta","App Developer",R.drawable.aman_gupta,"7737476484","https://github.com/ag597482"));
        developers.add(new team_members("Shalini Verma","App Developer",R.drawable.shalini,"9709371588","https://github.com/shaliniv16"));
        developers.add(new team_members("Anand Kumar","Designer",R.drawable.anand,"8797288013","https://github.com/Tech-ISM/spectrum-android-app  "));
        developers.add(new team_members("Pragdheesh R S","Designer",R.drawable.pragdhesh,"7358578982","https://github.com/Tech-ISM/spectrum-android-app  "));


        head_members.add(new team_members("Chayan Goyal","Vice President(SEE)",R.drawable.chayan_goyal,"9425066546","https://www.facebook.com/chayan.goyal.1"));
        head_members.add(new team_members("Sumanth","Secratary(SEE)",R.drawable.sumanth,"7680925866","https://m.facebook.com/sai.sumanth.7798"));
        head_members.add(new team_members("Shashank Sharma","Joint-Secratary(SEE)",R.drawable.shashank_sharma,"8909788706","https://www.facebook.com/shashank442sharma"));


    }



}
