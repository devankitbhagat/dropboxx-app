package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by ankit on 9/6/18.
 */

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ProductAdapter> list;

    private LayoutInflater inflater;

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;


    public ProductRecyclerAdapter(Context context, ArrayList<ProductAdapter> list) {
        this.context =  context;
        this.list = list;

        inflater = LayoutInflater.from(context);

        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        mImageLoader = VolleySingleton.getInstance().getImageLoader();
    }


    @Override
    public ProductRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product_recycler_item, parent, false);
        ProductRecyclerAdapter.MyViewHolder viewHolder = new ProductRecyclerAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductRecyclerAdapter.MyViewHolder holder, int position) {
        holder.productName.setText(list.get(position).getProductName());
        holder.productImage.setImageUrl(list.get(position).getProductImage(), mImageLoader);
        holder.productPrice.setText(String.valueOf(list.get(position).getProductPrice()));
    }

    @Override
    public int getItemCount() {
            return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        NetworkImageView productImage;
        TextView productName;
        TextView productPrice;
        CardView productCardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productCardView = itemView.findViewById(R.id.product_cardView);

        }
    }
}
