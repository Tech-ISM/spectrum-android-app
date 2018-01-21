package com.ujjwalagrawal.spectrum.profile.view;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.CardView;
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
//import com.ujjwalagrawal.spectrum_24.profile.model.TrialData;
import com.ujjwalagrawal.spectrum.profile.presenter.RegisterListPresenter;
import com.ujjwalagrawal.spectrum.profile.presenter.RegisterListPresenterImpl;
import com.ujjwalagrawal.spectrum.profile.provider.RetrofitRegisterListProvider;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

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
    private CardView cardView;



    private String token ;
    private View b1;
    private View b2;
    Random rnd = new Random();
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
        final TextView letter = view.findViewById(R.id.profile_letter);
        String first = sharedPrefs.getUsername().substring(0,1).toUpperCase();
        letter.setText(first);
        letter.setTextColor(context.getResources().getColor(R.color.md_blue_500));
        b1 = view.findViewById(R.id.b1);
        b2 = view.findViewById(R.id.b2);
        cardView = view.findViewById(R.id.profile_cardView);
        recyclerView = view.findViewById(R.id.register_event_recycler);
        recyclerView.setHasFixedSize(true);


        token = sharedPrefs.getAccessToken();
//        Log.d("Profile",token);

        layoutManager = new LinearLayoutManager(getContext());
        registerAdapter = new RegisterAdapter(getContext(),this);
        registerListPresenter = new RegisterListPresenterImpl(this, new RetrofitRegisterListProvider());
        recyclerView.setLayoutManager(layoutManager);

        b1.setBackgroundColor(getResources().getColor(R.color.md_red_900));//initial tab
//        registerAdapter.setData(trialData.getHello());
        recyclerView.setAdapter(registerAdapter);
        recyclerView.setItemAnimator(new SlideDownAlphaAnimator());
        Button single = view.findViewById(R.id.profile_single);

        single.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                registerListPresenter.requestRegistrationList(token,1);
                b1.setBackgroundColor(getResources().getColor(R.color.md_red_900));
                b2.setBackgroundColor(getResources().getColor(R.color.md_black_1000));
                Snackbar snackbar = Snackbar
                        .make(view, "REGISTER ON THE EVENTS BY CLICKING ON THE CARD", Snackbar.LENGTH_SHORT);

                snackbar.show();


            }
        });

        Button multiple = view.findViewById(R.id.profile_multiple);
        multiple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                registerListPresenter.requestRegistrationList(token,2);
                b2.setBackgroundColor(getResources().getColor(R.color.md_red_900));
                b1.setBackgroundColor(getResources().getColor(R.color.md_black_1000));
                Snackbar snackbar = Snackbar
                        .make(view, "MULTIPLE EVENTS CAN ONLY BE REGISTERED BY GOOGLE FORM", Snackbar.LENGTH_LONG);

                snackbar.show();


            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letter.setTextColor( Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
);
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
        registerListPresenter.requestRegistrationList(token,1);
        registerAdapter.notifyDataSetChanged();
    }

    public void changeParticipatedStatus(int participated, int id) {
           registerListPresenter.sendRegistrationData(id, participated,token);
    }


}
