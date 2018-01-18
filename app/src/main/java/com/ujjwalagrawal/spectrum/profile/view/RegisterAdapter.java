package com.ujjwalagrawal.spectrum.profile.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;



import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;



import com.ujjwalagrawal.spectrum.R;

import com.ujjwalagrawal.spectrum.helper.image_loaders.GlideImageLoader;
import com.ujjwalagrawal.spectrum.helper.image_loaders.ImageLoader;
import com.ujjwalagrawal.spectrum.profile.model.EventsList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham on 17-01-2018.
 */

public class RegisterAdapter extends RecyclerView.Adapter<RegisterAdapter.MyViewHolder> {

    private List<EventsList> data  = new ArrayList<>();
    private int single=0;
    Context context;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;
    private int multiple=0;
    private int total = data.size();
    private int count=total;
//    private int i;
//    for( i = 0;i < total ; i++){
//        EventsList element =data.get(i);
//        if(element.getType()==0){
//            single++;
//
//        } else {
//            multiple++;
//        }
//    }


    public RegisterAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        imageLoader = new GlideImageLoader(context);
    }
    void setData(List<EventsList> data) {
        this.data = data;
    }


//    public static class ViewHolder extends RecyclerView.ViewHolder{
//        private CardView cardView;
//
//        public ViewHolder(CardView v){
//            super(v);
//            cardView =v;
//        }
//
//    }

    @Override
    public RegisterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
       View view = layoutInflater.inflate(R.layout.event_register_card,parent,false);
       return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final EventsList eventsList = data.get(position);
        holder.event_name.setText(eventsList.getName());

        if(eventsList.getParticipated()==1){
            holder.checklist.setChecked(true);
        } else {
            holder.checklist.setChecked(false);
        }



//        Toast.makeText(context,data.size(),Toast.LENGTH_SHORT);
//
//        TextView textView  = cardView.findViewById(R.id.event_name);
//        textView.setText("hello");
//        Switch swi =cardView.findViewById(R.id.switch_register);
//        textView.setText(eventsList.getName());

    }




    @Override
    public int getItemCount() {
        return count;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView event_name;
        public Switch checklist;
        public CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);
            event_name= itemView.findViewById(R.id.event_name);
            checklist= itemView.findViewById(R.id.switch_register);
            cardView =itemView.findViewById(R.id.event_details);
        }
    }

}
