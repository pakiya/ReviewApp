package maanondev.myt.reviewapp;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class SlideShowAdapter extends PagerAdapter {

    private Context context;
    LayoutInflater inflater;

    public int[] images = {
            R.drawable.image_one_n,
            R.drawable.image_two_n,
            R.drawable.image_three_n,
            R.drawable.image_four_n,
            R.drawable.image_five_n,
            R.drawable.image_six_n,
            R.drawable.login_image,
    };


    public SlideShowAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {

        return images.length;

    }


    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view==(LinearLayout)object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.slideshow_layout,container,false);

        ImageView img = (ImageView) view.findViewById(R.id.imageView_id);

        //img.setImageResource(images[position]);

        Glide.with(context).load(images[position]).into(img);

        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout)object);

    }


}
