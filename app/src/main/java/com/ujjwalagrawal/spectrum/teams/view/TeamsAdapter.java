package com.ujjwalagrawal.spectrum.teams.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.teams.data.team_members;

import java.util.List;

/**
 * Created by hp-p on 28-Oct-17.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.MyViewHolder> {

    private List<team_members> data;
    private Context context;
    private boolean dev;

    public TeamsAdapter(List<team_members> data, Context context,Boolean dev) {
        this.context = context;
        this.data = data;
        this.dev=dev;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final team_members current_member = data.get(position);
        try {
            holder.image.setImageResource(current_member.getImage());
        }catch (Exception e){
            e.printStackTrace();
        }

        holder.member_name.setText(current_member.getName());
        holder.designation.setText(current_member.getDesignation());
        checks(holder,current_member);

        holder.mobile_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialintent = new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse("tel:" + current_member.getMobile_no()));
                context.startActivity(dialintent);
            }
        });
    }
    public void checks(MyViewHolder holder, final team_members current)
    {
        if (URLUtil.isValidUrl(current.getConcerned_url())) {
            holder.reference_url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
//                    builder.setToolbarColor(ContextCompat.getColor(context,R.color.cardview_dark_background));//NOT WORKING
                    builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary));
                    builder.setSecondaryToolbarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    builder.setExitAnimations(context, android.R.anim.slide_in_left,
                            android.R.anim.slide_out_right);
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.launchUrl(context, Uri.parse(current.getConcerned_url()));


                }
            });
        } else holder.reference_url.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView member_name;
        public TextView designation;
        public  ImageView reference_url;
        public ImageView mobile_no;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            member_name = (TextView) itemView.findViewById(R.id.name);
            designation = (TextView) itemView.findViewById(R.id.designation);
            mobile_no = (ImageView) itemView.findViewById(R.id.moblile_no);
            reference_url=(ImageView)itemView.findViewById(R.id.reference);
            if (dev)
                reference_url.setImageResource(R.drawable.github);
            else
                reference_url.setImageResource(R.drawable.facebook_app_logo);
        }
    }


}