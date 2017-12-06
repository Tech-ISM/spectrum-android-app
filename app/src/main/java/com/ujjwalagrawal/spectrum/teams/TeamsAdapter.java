package com.ujjwalagrawal.spectrum.teams;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;

import java.util.List;

/**
 * Created by hp-p on 28-Oct-17.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.MyViewHolder> {

    private List<team_members> data;
    private Context context;


    public TeamsAdapter(List<team_members> data, Context context) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final team_members current_member = data.get(position);
        holder.image.setImageResource(current_member.getImage());
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
        if(URLUtil.isValidUrl(current.getLinkedIn_url()))
        {
            holder.LinkedIn_url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse(current.getLinkedIn_url()));
                    context.startActivity(browserIntent);
                }
            });
        } else holder.LinkedIn_url.setVisibility(View.GONE);

        if(URLUtil.isValidUrl(current.getFacebook_url()))
        {
            holder.facebook_url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse(current.getFacebook_url()));
                    context.startActivity(browserIntent);
                }
            });
        } else holder.facebook_url.setVisibility(View.GONE);

        if(URLUtil.isValidUrl(current.getGithub_url()))
        {
            holder.github_url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse(current.getGithub_url()));
                    context.startActivity(browserIntent);
                }
            });
        } else holder.github_url.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView member_name;
        public TextView designation;
        public ImageView facebook_url;
        public ImageView github_url;
        public ImageView LinkedIn_url;
        public ImageView mobile_no;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            member_name = (TextView) itemView.findViewById(R.id.name);
            designation = (TextView) itemView.findViewById(R.id.designation);
            facebook_url = (ImageView) itemView.findViewById(R.id.facebook);
            github_url = (ImageView) itemView.findViewById(R.id.github);
            LinkedIn_url = (ImageView) itemView.findViewById(R.id.linkedIn);
            mobile_no = (ImageView) itemView.findViewById(R.id.moblile_no);
        }
    }


}