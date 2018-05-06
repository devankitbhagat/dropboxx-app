package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class Category extends Fragment {

    RecyclerView categoryRecyclerView;
    CategoryRecyclerAdapter categoryRecyclerAdapter;
    int numberOfColumns = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_category, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recycler);

        CategoryHandler categoryHandler = new CategoryHandler(getActivity());

        categoryHandler.getCategoryList(new CategoryHandlerCallback() {
            @Override
            public void onCategoryListAvailable(ArrayList<CategoryAdapter> list) {
                Toast.makeText(getActivity(), list.get(0).getCategoryName(), Toast.LENGTH_LONG).show();

                categoryRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
                categoryRecyclerAdapter = new CategoryRecyclerAdapter(getActivity(), list);
                categoryRecyclerView.setAdapter(categoryRecyclerAdapter);

            }

            @Override
            public void onCategoryListError(String error) {
                Toast.makeText(getActivity(), "ERROR: "+ error, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
