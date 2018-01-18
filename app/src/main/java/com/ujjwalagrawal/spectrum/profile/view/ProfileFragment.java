package com.ujjwalagrawal.spectrum.profile.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.easing.linear.Linear;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.helper.SharedPrefs;
import com.ujjwalagrawal.spectrum.profile.model.EventsList;
import com.ujjwalagrawal.spectrum.profile.model.RegistrationList;
import com.ujjwalagrawal.spectrum.profile.model.TrialData;
import com.ujjwalagrawal.spectrum.profile.presenter.RegisterListPresenter;
import com.ujjwalagrawal.spectrum.profile.presenter.RegisterListPresenterImpl;
import com.ujjwalagrawal.spectrum.profile.provider.RetrofitRegisterListProvider;


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
        recyclerView = view.findViewById(R.id.register_event_recycler);
        recyclerView.setHasFixedSize(true);
        context  = getContext();
        SharedPrefs sharedPrefs = new SharedPrefs(context);
        token = sharedPrefs.getAccessToken();
        Log.d("Profile",token);

        layoutManager = new LinearLayoutManager(getContext());
        registerAdapter = new RegisterAdapter(getContext());
        registerListPresenter = new RegisterListPresenterImpl(this, new RetrofitRegisterListProvider());
        recyclerView.setLayoutManager(layoutManager);

//        registerAdapter.setData(trialData.getHello());
        recyclerView.setAdapter(registerAdapter);
        registerListPresenter.requestRegistrationList(token);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                registerListPresenter.requestRegistrationList(token);
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
    public void SetData(List<EventsList> eventsListList){
        registerAdapter.setData(eventsListList);
        registerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

}
