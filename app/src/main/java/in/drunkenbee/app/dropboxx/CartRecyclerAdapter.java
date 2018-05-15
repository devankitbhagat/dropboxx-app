package in.drunkenbee.app.dropboxx;

import android.content.Context;
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
 * Created by ankit on 15/5/18.
 */

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<CartProductAdapter> list;
    private LayoutInflater inflater;

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    public CartRecyclerAdapter(Context context, ArrayList<CartProductAdapter> list){
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);

        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        mImageLoader = VolleySingleton.getInstance().getImageLoader();
    }


    @Override
    public CartRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.cart_recycler_item, parent, false);
        CartRecyclerAdapter.MyViewHolder viewHolder = new CartRecyclerAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CartRecyclerAdapter.MyViewHolder holder, int position) {

        holder.cartProductName.setText(list.get(position).getProductName());
        holder.cartProductPrice.setText(String.valueOf(list.get(position).getTotalPay()));
        holder.cartProductCount.setText(String.valueOf(list.get(position).getProductCount()));
        holder.cartProductImage.setImageUrl(list.get(position).getProductImage(), mImageLoader);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        NetworkImageView cartProductImage;
        TextView cartProductName;
        TextView cartProductPrice;
        TextView cartProductCount;

        public MyViewHolder(View itemView) {
            super(itemView);

            cartProductImage = itemView.findViewById(R.id.cart_product_image);
            cartProductName = itemView.findViewById(R.id.cart_product_name);
            cartProductPrice = itemView.findViewById(R.id.cart_product_price);
            cartProductCount = itemView.findViewById(R.id.cart_product_count);
        }
    }
}
