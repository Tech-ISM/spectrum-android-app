package com.ujjwalagrawal.spectrum.sponsorship.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mikepenz.itemanimators.SlideDownAlphaAnimator;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.sponsorship.model.SponsorsDetails;
import com.ujjwalagrawal.spectrum.sponsorship.presenter.SponsorsPresenter;
import com.ujjwalagrawal.spectrum.sponsorship.presenter.SponsorsPresenterImpl;
import com.ujjwalagrawal.spectrum.sponsorship.provider.RetrofitSponsorsListProvider;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SponsorsFragment extends Fragment implements SponsorsView {
    RecyclerView sponsor_recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SponsorsPresenter sponsorsPresenter;
    private SponsorsAdapter sponsorsAdapter;
    private ProgressBar progressBar;





    public SponsorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sponsors, container, false);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar_sponsors);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout_sponsors);
        sponsor_recyclerView = (RecyclerView) view.findViewById(R.id.sponsors_recycler_view);
        sponsor_recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(getContext());
        sponsorsAdapter = new SponsorsAdapter(getContext());

        sponsorsPresenter=new SponsorsPresenterImpl(this,new RetrofitSponsorsListProvider());
        sponsor_recyclerView.setLayoutManager(linearLayoutManager);
        sponsor_recyclerView.setAdapter(sponsorsAdapter);
        sponsor_recyclerView.setItemAnimator(new SlideDownAlphaAnimator());
        sponsorsPresenter.requestSponsorList();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                sponsorsPresenter.requestSponsorList();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }



    @Override
    public void setData(List<SponsorsDetails> sponsorsDetailsList) {
        sponsorsAdapter.setData(sponsorsDetailsList);
        sponsorsAdapter.notifyDataSetChanged();


    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showProgressBar(boolean show) {
        if(show) {
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.INVISIBLE);
        }

    }

//    @Override
//    public void openImageUrl(String url) {
//
//    }
}
