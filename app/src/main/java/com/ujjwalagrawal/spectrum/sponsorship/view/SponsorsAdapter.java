package com.ujjwalagrawal.spectrum.sponsorship.view;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;

import com.ujjwalagrawal.spectrum.helper.image_loaders.GlideImageLoader;
import com.ujjwalagrawal.spectrum.helper.image_loaders.ImageLoader;
import com.ujjwalagrawal.spectrum.sponsorship.model.SponsorsDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shubham on 27-10-2017.
 */

public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.MyViewHolder>{
    private List<SponsorsDetails> data =new ArrayList<>();
    Context context;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public SponsorsAdapter(Context context1) {
        context = context1;
        layoutInflater = LayoutInflater.from(context1);
        imageLoader = new GlideImageLoader(context);
    }

    public void setData(List<SponsorsDetails> data) {
        this.data = data;
    }

    @Override
    public SponsorsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = layoutInflater.inflate(R.layout.sponsors_item,parent,false);
        return new SponsorsAdapter.MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final SponsorsDetails eventsData = data.get(position);
        imageLoader.loadImage(eventsData.getImage_url(),holder.sponsor_image,holder.progressBar);
        holder.sponsor_name.setText(eventsData.getName());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentActivity activity = (FragmentActivity)(context);
                FragmentManager fm = activity.getSupportFragmentManager();
//                EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView sponsor_image;
        public RelativeLayout relativeLayout;
        public TextView sponsor_name;
        public ProgressBar progressBar;
        public MyViewHolder(View itemView){
            super(itemView);
            sponsor_image = (ImageView) itemView.findViewById(R.id.sponsorImg);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.sponsor_relativeLayout);
            sponsor_name = (TextView) itemView.findViewById(R.id.sponsorName);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar_sponsors);
        }
    }
}


