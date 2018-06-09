package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class Product extends Fragment {

    RecyclerView productRecyclerView;
    ProductRecyclerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_product, container, false);
        ArrayList<ProductAdapter> productArrayList = (ArrayList<ProductAdapter>)getArguments().getSerializable("product");
        productRecyclerView = view.findViewById(R.id.product_recycler);
        Toast.makeText(getActivity(), "PRODUCTLIST"+productArrayList.get(0).getProductName(), Toast.LENGTH_LONG).show();

        productRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ProductRecyclerAdapter(getActivity(), productArrayList);
        productRecyclerView.setAdapter(adapter);

        return view;
    }
}
