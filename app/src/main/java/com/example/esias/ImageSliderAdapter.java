package com.example.esias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageSliderAdapter extends PagerAdapter {
    private int[] image;
    private Context context;
    private LayoutInflater layoutInflater;
    private int customPosition;

    public ImageSliderAdapter(int[] image,Context context)
    {
        this.context=context;
        this.image=image;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if (customPosition>4)
            customPosition=0;

        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemVeiw=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageslide=itemVeiw.findViewById(R.id.imageviewslide);
        imageslide.setImageResource(image[customPosition]);
        customPosition++;
        container.addView(itemVeiw);
        return itemVeiw;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
