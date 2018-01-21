package com.ujjwalagrawal.spectrum.home.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ujjwalagrawal.spectrum.R;

/**
 * Created by hp-p on 19-Jan-18.
 */

public class SwishyTransformer implements ViewPager.PageTransformer {

    public static final float MIN_SCALE = 0.2f;

    public SwishyTransformer(){
    }

    @Override
    public void transformPage(View page, float position) {


        //System.out.println("position " + position);
        if(position < -1){

        }
        else if(position < -0.6f) {
            // -1 to -0.6

            page.setScaleX(0.2f);
            page.setScaleY(0.2f);
            page.setTranslationX(0.4f * page.getWidth());


            RelativeLayout rl = (RelativeLayout) page;

            ImageView view = (ImageView) rl.findViewById(R.id.large_image);
            view.setVisibility(View.INVISIBLE);
            ImageView placeholder = (ImageView) rl.findViewById(R.id.placeholder_view);
            placeholder.setVisibility(View.VISIBLE);
            placeholder.setRotation(2*360*position);

        }
        else if(position < -0.4f){
            // -0.6 to -0.4
            page.setScaleX(0.2f);
            page.setScaleY(0.2f);
            page.setTranslationX(0.4f * page.getWidth());


            RelativeLayout rl = (RelativeLayout) page;

            ImageView view = (ImageView) rl.findViewById(R.id.large_image);
            view.setVisibility(View.INVISIBLE);
            ImageView placeholder = (ImageView) rl.findViewById(R.id.placeholder_view);
            placeholder.setVisibility(View.VISIBLE);
            placeholder.setRotation(2*360*position);

        }

        else if(position < 0.0f){
            //-0.4 to 0.0
            RelativeLayout rl = (RelativeLayout) page;
            ImageView view = (ImageView) rl.findViewById(R.id.large_image);
            view.setVisibility(View.VISIBLE);
            ImageView placeholder = (ImageView) rl.findViewById(R.id.placeholder_view);
            placeholder.setVisibility(View.INVISIBLE);

            float scaleFactor = 1 - 2 * Math.abs(position);
            page.setScaleY(scaleFactor);
            page.setScaleX(scaleFactor);
            //System.out.println("pw : "+page.getWidth());
            page.setTranslationX((1-scaleFactor)/2f * page.getWidth());
        }

        else if(position < 0.4f){
            //0.0 to 0.4
            RelativeLayout rl = (RelativeLayout) page;

            ImageView view = (ImageView) rl.findViewById(R.id.large_image);
            view.setVisibility(View.VISIBLE);
            ImageView placeholder = (ImageView) rl.findViewById(R.id.placeholder_view);
            placeholder.setVisibility(View.INVISIBLE);


            float scaleFactor = 1 - 2 * Math.abs(position);
            page.setScaleY(scaleFactor);
            page.setScaleX(scaleFactor);
            //System.out.println("pw : "+page.getWidth());
            page.setTranslationX(- (1-scaleFactor)/2f * page.getWidth());
        }

        else if(position < 0.6f){
            //0.4 to 0.6
            page.setScaleX(0.2f);
            page.setScaleY(0.2f);
            //System.out.println("pw : "+page.getWidth());
            page.setTranslationX(- 0.4f * page.getWidth());

            RelativeLayout rl = (RelativeLayout) page;

            ImageView view = (ImageView) rl.findViewById(R.id.large_image);
            view.setVisibility(View.INVISIBLE);
            ImageView placeholder = (ImageView) rl.findViewById(R.id.placeholder_view);
            placeholder.setVisibility(View.VISIBLE);

            placeholder.setRotation(2*360*position);

        }

        else if(position < 1f){
            //0.6 to 1
            page.setScaleX(0.2f);
            page.setScaleY(0.2f);
            //System.out.println("pw : "+page.getWidth());
            page.setTranslationX(- 0.4f * page.getWidth());


            RelativeLayout rl = (RelativeLayout) page;

            ImageView view = (ImageView) rl.findViewById(R.id.large_image);
            view.setVisibility(View.INVISIBLE);
            ImageView placeholder = (ImageView) rl.findViewById(R.id.placeholder_view);
            placeholder.setVisibility(View.VISIBLE);

            placeholder.setRotation(2*360*position);
        }

    }

}