package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.ArrayList;

import ss.com.bannerslider.Slider;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

/**
 * Created by ankit on 5/5/18.
 */

public class BannerSliderAdapter extends SliderAdapter {

    private Context context;
    private ArrayList<BannerAdapter> bannerList;

    public BannerSliderAdapter(Context context, ArrayList<BannerAdapter> bannerList) {

        this.context = context;
        this.bannerList = bannerList;

    }


    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {

        imageSlideViewHolder.bindImageSlide(bannerList.get(position).getBannerImage());
    }
}
