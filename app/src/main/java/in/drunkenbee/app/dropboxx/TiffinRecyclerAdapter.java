package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ankit on 25/3/18.
 */

public class TiffinRecyclerAdapter extends RecyclerView.Adapter<TiffinRecyclerAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private HashMap<String, ArrayList<String>> itemHashMap;
    private List<String> dayList;

    public TiffinRecyclerAdapter(Context context, HashMap<String, ArrayList<String>> itemHashMap){
        inflater = LayoutInflater.from(context);
        this.itemHashMap = new HashMap<String, ArrayList<String>>(itemHashMap);
        this.context = context;
        this.dayList = new ArrayList<String>(itemHashMap.keySet());
        Log.e("SIZE", String.valueOf(this.itemHashMap.size()));
    }

    @Override
    public TiffinRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tiffin_recycler_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TiffinRecyclerAdapter.MyViewHolder holder, int position) {
        holder.day.setText(dayList.get(position));
        holder.dayItemList.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, itemHashMap.get(dayList.get(position))));
    }

    @Override
    public int getItemCount() {
        return itemHashMap.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView day;
        ListView dayItemList;

        public MyViewHolder(View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            dayItemList = itemView.findViewById(R.id.itemList);
        }
    }
}
