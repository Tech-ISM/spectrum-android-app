package com.ujjwalagrawal.spectrum;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 26-10-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NotificationsViewHolder>{
    //making a view holder to cache the value of the view
    Context context;
    ArrayList<String> title;
    ArrayList<String> description;
    ArrayList<String> event_id;
    ArrayList<String> date;
    ArrayList<String> time;
    class NotificationsViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView event_id;
        TextView date;
        TextView time;
        TextView description;

        public NotificationsViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            event_id = (TextView) itemView.findViewById(R.id.event_id);
            date = (TextView) itemView.findViewById(R.id.date);
            time = (TextView) itemView.findViewById(R.id.event_id);
            description = (TextView) itemView.findViewById(R.id.event_id);
        }
    }
    @Override
    public NotificationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.notifications, parent, false);
        //tossing the view for caching
        NotificationsViewHolder NotificationViewHolder = new NotificationsViewHolder(view);

        return NotificationViewHolder;

    }
    @Override
    public void onBindViewHolder(NotificationsViewHolder holder, int position) {
        holder.title.setText(title.get(position));
        holder.event_id.setText(event_id.get(position));
        holder.date.setText(date.get(position));
        holder.time.setText(time.get(position));
        holder.description.setText(description.get(position));
    }
    @Override
    public int getItemCount() {
        return title == null ? 0 : title.size();
    }
    public RecyclerViewAdapter(Context context,ArrayList<String> title, ArrayList<String> description, ArrayList<String> event_id,ArrayList<String> date, ArrayList<String> time){

    }
}
