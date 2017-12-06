package com.ujjwalagrawal.spectrum.teams;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.ujjwalagrawal.spectrum.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hp-p on 28-Oct-17.
 */

public class TeamsFragment extends Fragment {
    private List<team_members> data;

    public TeamsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView developers_Recyclerview, designers_Recyclerview;
        RecyclerView.Adapter designerAdapter, developerAdapter;


        View view = inflater.inflate(R.layout.fragment_teams, container, false); // Inflate the layout for this fragment

        data=new ArrayList<>();
        fill_with_data();

        developers_Recyclerview = (RecyclerView) view.findViewById(R.id.developer_recycler_view);
        developers_Recyclerview.setHasFixedSize(true);
        developers_Recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        developerAdapter = new TeamsAdapter(data, getContext());

        designers_Recyclerview = (RecyclerView) view.findViewById(R.id.designer_recycler_view);
        designers_Recyclerview.setHasFixedSize(true);
        designers_Recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        designerAdapter = new TeamsAdapter(data, getContext());

        developers_Recyclerview.setAdapter(developerAdapter);
        designers_Recyclerview.setAdapter(designerAdapter);

        return view;
    }

    public void fill_with_data()//will be used to set data finally
    {
        team_members asd=new team_members("XYZ ABC","Akhil Vishwas Vaidya",R.drawable.framelayout3,"12345678","https://www.youtube.com/","https://www.youtube.com/","https://www.youtube.com/");
        team_members zxc=new team_members("Ravi Chandran Ashwin","ABC XYZ",R.drawable.framelayout1,"https://www.youtube.com/","https://www.youtube.com/","https://www.youtube.com/","https://www.youtube.com/");

        data.add(asd);
        data.add(zxc);

    }



}
