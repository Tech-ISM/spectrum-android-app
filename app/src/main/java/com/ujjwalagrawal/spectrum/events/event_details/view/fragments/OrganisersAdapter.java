package com.ujjwalagrawal.spectrum.events.event_details.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.events.event_details.data.OrganiserDetails;
import com.ujjwalagrawal.spectrum.events.event_details.view.EventDetailActivity;
import com.ujjwalagrawal.spectrum.events.event_list.data.EventData;
import com.ujjwalagrawal.spectrum.helper.image_loaders.GlideImageLoader;
import com.ujjwalagrawal.spectrum.helper.image_loaders.ImageLoader;
import com.ujjwalagrawal.spectrum.home.HomeActivity;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrganisersAdapter extends RecyclerView.Adapter<OrganisersAdapter.MyViewHolder> {

    private List<OrganiserDetails> data = new ArrayList<>();
    Context context;
    private LayoutInflater layoutInflater;


    public OrganisersAdapter(Context context1) {
        context = context1;
        layoutInflater = LayoutInflater.from(context1);
    }
    void setData(List<OrganiserDetails> data)
    {
        this.data = data;
    }


    @Override
    public OrganisersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.card_organizer,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final OrganiserDetails organiserDetails = data.get(position);


        holder.organizerName.setText(organiserDetails.getName());
        holder.organizerPhone.setText(organiserDetails.getMobile());

        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialintent = new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse("tel:" + organiserDetails.getMobile()));
                context.startActivity(dialintent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView organizerName;
        TextView organizerPhone;
        Button callButton;
        public AVLoadingIndicatorView progressBar;
        public MyViewHolder(View itemView){
            super(itemView);

            organizerName = (TextView) itemView.findViewById(R.id.organizer_name);
            organizerPhone = (TextView) itemView.findViewById(R.id.organizer_phone);
            callButton = (Button) itemView.findViewById(R.id.call_button);
        }
    }
}
