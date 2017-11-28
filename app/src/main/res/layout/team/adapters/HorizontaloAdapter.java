package com.ujjwalagrawal.spectrum.team.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;

import java.util.ArrayList;

public class HorizontaloAdapter  extends RecyclerView.Adapter<HorizontaloAdapter.MyViewHolder> {
    ArrayList<SingleHorizontalo> data = new ArrayList<>();

    public HorizontaloAdapter(ArrayList<SingleHorizontalo> data) {
        this.data = data;

    }

    @Override
    public HorizontaloAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontalo_single_row, parent, false);
        return new HorizontaloAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontaloAdapter.MyViewHolder holder, int position) {

        holder.description.setText(data.get(position).getDesc());
        holder.title.setText(data.get(position).getTitle());
        holder.pubDate.setText(data.get(position).getPubDate());
        holder.image.setImageResource(data.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, pubDate;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            pubDate = (TextView) itemView.findViewById(R.id.published_date);
            image = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }
}
