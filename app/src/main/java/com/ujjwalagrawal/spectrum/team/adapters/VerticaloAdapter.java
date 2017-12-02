package com.ujjwalagrawal.spectrum.team.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;

import java.util.ArrayList;

public class VerticaloAdapter extends RecyclerView.Adapter<VerticaloAdapter.MyViewHolder> {
    private ArrayList<SingleVerticalo> data = new ArrayList<>();

    public VerticaloAdapter(ArrayList<SingleVerticalo> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_single_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.title.setText(data.get(position).getHeader());
        holder.description.setText(data.get(position).getSubHeader());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, description;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
