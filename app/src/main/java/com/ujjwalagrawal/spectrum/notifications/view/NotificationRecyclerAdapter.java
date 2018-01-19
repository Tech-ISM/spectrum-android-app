package com.ujjwalagrawal.spectrum.notifications.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.notifications.data.NotificationsDetails;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.events.event_details.view.EventDetailActivity;
import com.ujjwalagrawal.spectrum.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class NotificationRecyclerAdapter extends RecyclerView.Adapter<NotificationRecyclerAdapter.MyViewHolder>{
    //making a view holder to cache the value of the view
    Context context;
    LayoutInflater layoutInflater;
    List<NotificationsDetails> notificationsDetailsList = new ArrayList<>();

    public NotificationRecyclerAdapter(Context context) {
        context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.notifications_item,parent,false);
        return new NotificationRecyclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final NotificationsDetails notificationsDetails = notificationsDetailsList.get(position);

        holder.title.setText(notificationsDetails.getTitle());
        holder.date.setText(notificationsDetails.getDate());
        holder.time.setText(notificationsDetails.getTime());
        holder.description.setText(notificationsDetails.getMessage());

        holder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventDetailActivity.class);
                intent.putExtra("event_id",notificationsDetails.getEvent_id());
                ((HomeActivity)context).startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notificationsDetailsList.size();
    }

    public void setData(List<NotificationsDetails> notification_list) {
        this.notificationsDetailsList = notification_list;
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView date;
        TextView time;
        TextView description;
        public MyViewHolder(View itemView){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            time = (TextView) itemView.findViewById(R.id.time);
            description = (TextView) itemView.findViewById(R.id.description_textview);
        }
    }
}
