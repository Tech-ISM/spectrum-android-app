package com.ujjwalagrawal.spectrum.sponsorship.view;

/**
 * Created by shubham on 26-10-2017.
 */

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ujjwalagrawal.spectrum.R;

import static android.R.drawable.sym_action_call;
import static com.ujjwalagrawal.spectrum.R.drawable.facebook;
import static com.ujjwalagrawal.spectrum.R.drawable.website;


public class SponsorsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] company_names;
    private String[] phone_no;
    private String[] image_url;


    public SponsorsAdapter(String[] company_names, String[] phone_no, String[] image_url) {
        this.company_names = company_names;
        this.phone_no = phone_no;
        this.image_url = image_url;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

        @Override
        public SponsorsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
            CardView cv=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.sponsor_details,parent,false);
            return new ViewHolder(cv);
        }

        @Override
        public int getItemCount(){
            return company_names.length;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder,int position){
            CardView cardView=holder.cardView;
            ImageView imageView =(ImageView)cardView.findViewById(R.id.sponsor_image);
            imageView.setImageDrawable();
            imageView.setContentDescription("company logo");
            TextView textView=(TextView)cardView.findViewById(R.id.company_name);
            textView.setText(company_names[position]);
            TextView textView1=(TextView)cardView.findViewById(R.id.mobile_no);
            textView1.setText(phone_no[position]);
            ImageView imageView1=(ImageView)cardView.findViewById(R.id.phone_launcher);
            imageView1.setImageResource(@android:drawable/sym_action_call);
            imageView1.setContentDescription("phone no");
            ImageView imageView2=(ImageView)cardView.findViewById(R.id.facebook_icon);
            imageView2.setImageResource(@drawable/facebook);
            imageView2.setContentDescription("facebook launcher");
            ImageView imageView3=(ImageView)cardView.findViewById(R.id.website_icon);
            imageView3.setImageResource(@drawable/website);





        }



}

