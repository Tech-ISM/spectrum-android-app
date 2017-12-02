package com.ujjwalagrawal.spectrum.team.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.team.adapters.MainAdapter;
import com.ujjwalagrawal.spectrum.team.adapters.SingleHorizontal;
import com.ujjwalagrawal.spectrum.team.adapters.SingleHorizontalo;
import com.ujjwalagrawal.spectrum.team.adapters.SingleVertical;
import com.ujjwalagrawal.spectrum.team.adapters.SingleVerticalo;

import java.util.ArrayList;


public class TeamFragment extends Fragment {
    private ArrayList<Object> objects = new ArrayList<>();

private MainAdapter adapter;


    public TeamFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_View);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MainAdapter(getContext(),getObject());
        recyclerView.setAdapter(adapter);



        return view;
    }





    private ArrayList<Object> getObject() {
        objects.add(getVerticalData().get(0));
        objects.add(getHorizontaloData().get(0));
        objects.add(getVerticaloData().get(0));
        objects.add(getHorizontalData().get(0));
        return objects;
    }

    public static ArrayList<SingleVertical> getVerticalData() {
        ArrayList<SingleVertical> singleVerticals = new ArrayList<>();
        singleVerticals.add(new SingleVertical("Spectrum Team", ""));  //
        return singleVerticals;
    }

    public static ArrayList<SingleVerticalo> getVerticaloData() {
        ArrayList<SingleVerticalo> singleVerticalso = new ArrayList<>();
        singleVerticalso.add(new SingleVerticalo("Developement Team ", ""));  //
        return singleVerticalso;
    }

    public static ArrayList<SingleHorizontalo> getHorizontaloData() {
        ArrayList<SingleHorizontalo> singleHorizontalso = new ArrayList<>();
        singleHorizontalso.add(new SingleHorizontalo(R.drawable.a1, "Suresh Raina", "Organizer", ""));
        singleHorizontalso.add(new SingleHorizontalo(R.drawable.a2,"Abc Defghi", "Designer", ""));
        singleHorizontalso.add(new SingleHorizontalo(R.drawable.a3, "Abc Defghi", "App Developer", ""));
        singleHorizontalso.add(new SingleHorizontalo(R.drawable.a4, "Abc Defghi", "Content Writer", ""));
        singleHorizontalso.add(new SingleHorizontalo(R.drawable.a5, "Abc Defghi", "Organizer", ""));
        singleHorizontalso.add(new SingleHorizontalo(R.mipmap.charlie, "Abc Defghi", "Organizer", ""));

        return singleHorizontalso;
    }


    public static ArrayList<SingleHorizontal> getHorizontalData() {
        ArrayList<SingleHorizontal> singleHorizontals = new ArrayList<>();
        singleHorizontals.add(new SingleHorizontal(R.mipmap.mrbean, "Mr. Bean", "App Developer", "https://www.github.com"));
        singleHorizontals.add(new SingleHorizontal(R.mipmap.jim,"Abc Defghi", "App Developer", ""));
        singleHorizontals.add(new SingleHorizontal(R.drawable.a3, "Abc Defghi", "App Developer", ""));
        singleHorizontals.add(new SingleHorizontal(R.drawable.a4, "Abc Defghi", "App Developer", ""));
        singleHorizontals.add(new SingleHorizontal(R.drawable.a5, "Abc Defghi", "App Developer", ""));
        singleHorizontals.add(new SingleHorizontal(R.mipmap.charlie, "Abc Defghi", "App Developer", ""));

        return singleHorizontals;
    }

}
