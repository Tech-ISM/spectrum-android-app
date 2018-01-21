package com.ujjwalagrawal.spectrum.events.event_details.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.events.event_details.data.EventDetails;
import com.ujjwalagrawal.spectrum.events.event_details.presenter.EventDetailsPresenter;
import com.ujjwalagrawal.spectrum.events.event_details.presenter.EventDetailsPresenterImpl;
import com.ujjwalagrawal.spectrum.events.event_details.provider.RetrofitEventDetailsProvider;
import com.ujjwalagrawal.spectrum.events.event_details.view.fragments.AtendeeFragment;
import com.ujjwalagrawal.spectrum.events.event_details.view.fragments.DescriptionFragment;
import com.ujjwalagrawal.spectrum.events.event_details.view.fragments.TimeDateFragment;
import com.ujjwalagrawal.spectrum.events.event_list.view.EventListFragment;
import com.ujjwalagrawal.spectrum.helper.image_loaders.GlideImageLoader;
import com.ujjwalagrawal.spectrum.helper.image_loaders.ImageLoader;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.long1.spacetablayout.SpaceTabLayout;

public class EventDetailActivity extends AppCompatActivity  implements EventDetailsView {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.spaceTabLayout)
    SpaceTabLayout spaceTabLayout;
    @BindView(R.id.eventImageView)
    ImageView eventImageView;
    @BindView(R.id.event_image_view_second)
    ImageView eventImageViewSecond;
    @BindView(R.id.eventTitleTextView)
    TextView eventTitleTextView;
    @BindView(R.id.progressBar)
    AVLoadingIndicatorView progressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private int event_id;
    private Context context;
    ImageLoader imageLoader;
    private EventDetailsPresenter eventDetailsPresenter;
    TimeDateFragment timeDateFragment;
    DescriptionFragment descriptionFragment;
    AtendeeFragment atendeeFragment;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);
        event_id=getIntent().getIntExtra("event_id",0);
        context = this;
        imageLoader = new GlideImageLoader(context);
        eventDetailsPresenter =new EventDetailsPresenterImpl(this,new RetrofitEventDetailsProvider());
        eventDetailsPresenter.getEventDetails(event_id);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressDialog.setMessage("Loading");
//        progressDialog.show();

        init(savedInstanceState);

    }

    private void init(Bundle savedInstanceState) {

        List<Fragment> fragmentList = new ArrayList<>();

        timeDateFragment = TimeDateFragment.newInstance();
        descriptionFragment = DescriptionFragment.newInstance();
        atendeeFragment = AtendeeFragment.newInstance();

        fragmentList.add(timeDateFragment);
        fragmentList.add(descriptionFragment);
        fragmentList.add(atendeeFragment);

        spaceTabLayout.initialize(viewPager, getSupportFragmentManager(),
                fragmentList, savedInstanceState);

    }

    private void dismissLoadingDialog() {
        if(progressDialog!=null){
            progressDialog.dismiss();
        }
    }

    @Override
    public void showProgressbar(boolean show) {
        if (show){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

    }
    @Override
    public void setEventDetails(EventDetails eventDetails) {

        eventTitleTextView.setText(eventDetails.getName());
        imageLoader.loadImage(eventDetails.getImage(),eventImageViewSecond,progressBar);
        imageLoader.loadImage(eventDetails.getImage_blur(),eventImageView,progressBar);
        descriptionFragment.setDescription(eventDetails.getDescription());
        timeDateFragment.update(eventDetails);
        atendeeFragment.setAtendee(eventDetails.getAttendees()+"",eventDetails.getPrize_description());

    }
}
