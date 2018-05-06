package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.Picasso;

import ss.com.bannerslider.ImageLoadingService;

/**
 * Created by ankit on 5/5/18.
 */

public class BannerImageLoadingService implements ImageLoadingService {

    public Context context;

    public BannerImageLoadingService(Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Picasso.with(context).load(url).into(imageView);
    }

    @Override
    public void loadImage(int resource, ImageView imageView) {
        Picasso.with(context).load(resource).into(imageView);
    }

    @Override
    public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {
        Picasso.with(context).load(url).placeholder(placeHolder).error(errorDrawable).into(imageView);
    }
}
