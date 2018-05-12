package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by ankit on 6/5/18.
 */

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.MyViewHolder>   {

    private Context context;
    private ArrayList<CategoryAdapter> list;
    private LayoutInflater inflater;

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    public CategoryRecyclerAdapter(Context context, ArrayList<CategoryAdapter> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);

        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        mImageLoader = VolleySingleton.getInstance().getImageLoader();
    }

    @Override
    public CategoryRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.category_recycler_item, parent, false);
        CategoryRecyclerAdapter.MyViewHolder viewHolder = new CategoryRecyclerAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryRecyclerAdapter.MyViewHolder holder, final int position) {

        holder.categoryName.setText(list.get(position).getCategoryName());
        holder.categoryImage.setImageUrl(list.get(position).getCategoryImage(), mImageLoader);
        holder.categoryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"POSITION "+position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        NetworkImageView categoryImage;
        TextView categoryName;
        CardView categoryCardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.category_image);
            categoryName = itemView.findViewById(R.id.category_name);
            categoryCardView = itemView.findViewById(R.id.category_cardView);

        }
    }
}
