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
    private List<team_members> developers;
    private List<team_members> organizers;
    private  RecyclerView            developers_Recyclerview ,   organizers_Recyclerview;
    private  RecyclerView.Adapter    developerAdapter        ,   organizerAdapter;

    public TeamsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_teams, container, false); // Inflate the layout for this fragment

        developers=new ArrayList<>();
        organizers=new ArrayList<>();

        put_data();
        set_adapters(view);

        return view;
    }

    public void set_adapters(View view)
    {
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
    }

    public void put_data()//will be used to set data finally
    {

        developers.add(new team_members("Akhil Vaidya","junior developer",R.drawable.framelayout3,"23456345346","https://github.com/Tech-ISM/spectrum-android-app"));
        developers.add(new team_members("Shubham Raj","junior developer",R.drawable.framelayout3,"2345634534346","https://github.com/Tech-ISM/spectrum-android-app"));
        developers.add(new team_members("Aman Gupta","junior developer",R.drawable.framelayout3,"234563434553346","https://github.com/Tech-ISM/spectrum-android-app"));
        developers.add(new team_members("Aman Gupta","junior developer",R.drawable.framelayout3,"234563434553346","https://github.com/Tech-ISM/spectrum-android-app"));
        developers.add(new team_members("Aman Gupta","junior developer",R.drawable.framelayout3,"234563434553346","https://github.com/Tech-ISM/spectrum-android-app"));
        developers.add(new team_members("Aman Gupta","junior developer",R.drawable.framelayout3,"234563434553346","https://github.com/Tech-ISM/spectrum-android-app"));
        developers.add(new team_members("Aman Gupta","junior developer",R.drawable.framelayout3,"234563434553346","https://github.com/Tech-ISM/spectrum-android-app"));

        organizers.add(new team_members("Saurabh Goenka","organizers",R.drawable.framelayout1,"23456s343","https://www.facebook.com/profile.php?id=100000383742195&ref=br_rs"));
        organizers.add(new team_members("Saurabh Goenka","organizers",R.drawable.framelayout1,"23456s343","https://www.facebook.com/profile.php?id=100000383742195&ref=br_rs"));
        organizers.add(new team_members("Saurabh Goenka","organizers",R.drawable.framelayout1,"23456s343","https://www.facebook.com/profile.php?id=100000383742195&ref=br_rs"));
        organizers.add(new team_members("Saurabh Goenka","organizers",R.drawable.framelayout1,"23456s343","https://www.facebook.com/profile.php?id=100000383742195&ref=br_rs"));
        organizers.add(new team_members("Saurabh Goenka","organizers",R.drawable.framelayout1,"23456s343","https://www.facebook.com/profile.php?id=100000383742195&ref=br_rs"));
        organizers.add(new team_members("sanskar Shrivastava","organizers",R.drawable.framelayout1,"23456s343","https://www.facebook.com/profile.php?id=100000383742195&ref=br_rs"));

    }



}
