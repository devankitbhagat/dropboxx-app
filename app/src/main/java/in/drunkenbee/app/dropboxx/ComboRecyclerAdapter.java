package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ankit on 5/5/18.
 */

public class ComboRecyclerAdapter extends RecyclerView.Adapter<ComboRecyclerAdapter.MyViewHolder>  {

    private Context context;
    private ArrayList<ComboAdapter> combolist;
    private LayoutInflater inflater;

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    public ComboRecyclerAdapter(Context context, ArrayList<ComboAdapter> combolist){
        inflater = LayoutInflater.from(context);
        this.combolist = combolist;

        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        mImageLoader = VolleySingleton.getInstance().getImageLoader();

    }

    @Override
    public ComboRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.combo_recycler_item, parent, false);
        ComboRecyclerAdapter.MyViewHolder viewHolder = new ComboRecyclerAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ComboRecyclerAdapter.MyViewHolder holder, int position) {

        holder.comboName.setText(combolist.get(position).getComboName());
        holder.comboDescription.setText(combolist.get(position).getComboDescription());
        holder.comboPrice.setText("Rs "+combolist.get(position).getComboPrice());
        holder.comboImage.setImageUrl(combolist.get(position).getComboImage(), mImageLoader);
    }

    @Override
    public int getItemCount() {
        return combolist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView comboName;
        TextView comboDescription;
        TextView comboPrice;
        NetworkImageView comboImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            comboName = itemView.findViewById(R.id.combo_name);
            comboDescription = itemView.findViewById(R.id.combo_description);
            comboPrice = itemView.findViewById(R.id.combo_price);
            comboImage = itemView.findViewById(R.id.combo_image);

        }

    }
}
