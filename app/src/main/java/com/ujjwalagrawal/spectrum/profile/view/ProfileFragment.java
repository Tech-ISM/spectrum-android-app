package com.ujjwalagrawal.spectrum.profile.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.itemanimators.SlideDownAlphaAnimator;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.helper.SharedPrefs;
import com.ujjwalagrawal.spectrum.profile.model.EventsList;
//import com.ujjwalagrawal.spectrum.profile.model.TrialData;
import com.ujjwalagrawal.spectrum.profile.presenter.RegisterListPresenter;
import com.ujjwalagrawal.spectrum.profile.presenter.RegisterListPresenterImpl;
import com.ujjwalagrawal.spectrum.profile.provider.RetrofitRegisterListProvider;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements RegisterListView{

    private Context context;
    RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    private SwipeRefreshLayout swipeRefreshLayout;
    private RegisterListPresenter registerListPresenter;
    private RegisterAdapter registerAdapter;



    private String token ;
    public boolean verified;
//    private TrialData trialData;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen

        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        swipeRefreshLayout = view.findViewById(R.id.swipe_layout_profile);
        context  = getContext();
        SharedPrefs sharedPrefs = new SharedPrefs(context);
        TextView name=view.findViewById(R.id.user_name);
        name.setText(sharedPrefs.getUsername());
        TextView phone = view.findViewById(R.id.user_mobile);
        phone.setText(sharedPrefs.getMobile());
        TextView email = view.findViewById(R.id.user_email);
        email.setText(sharedPrefs.getEmail());
        recyclerView = view.findViewById(R.id.register_event_recycler);
        recyclerView.setHasFixedSize(true);

        token = sharedPrefs.getAccessToken();
//        Log.d("Profile",token);

        layoutManager = new LinearLayoutManager(getContext());
        registerAdapter = new RegisterAdapter(getContext(),this);
        registerListPresenter = new RegisterListPresenterImpl(this, new RetrofitRegisterListProvider());
        recyclerView.setLayoutManager(layoutManager);

//        registerAdapter.setData(trialData.getHello());
        recyclerView.setAdapter(registerAdapter);
        recyclerView.setItemAnimator(new SlideDownAlphaAnimator());
        Button single = view.findViewById(R.id.profile_single);
        single.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                registerListPresenter.requestRegistrationList(token,1);
            }
        });

        Button multiple = view.findViewById(R.id.profile_multiple);
        multiple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                registerListPresenter.requestRegistrationList(token,2);
            }
        });

        registerListPresenter.requestRegistrationList(token,1);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                registerListPresenter.requestRegistrationList(token,1);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void SetData(List<EventsList> eventsListList,int type){
        List<EventsList> eventsLists = new ArrayList<>();
        for (int i=0;i<eventsListList.size();i++){
            if (eventsListList.get(i).getType()==type)
            eventsLists.add(eventsListList.get(i));

        }
        registerAdapter.setData(eventsLists);
        Log.d("size",eventsListList.size()+"");
        registerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onParticipatedStatusUpdated() {
        registerAdapter.notifyDataSetChanged();
    }

    public void changeParticipatedStatus(int participated, int id) {
           registerListPresenter.sendRegistrationData(id,5,participated,token);
    }
}
