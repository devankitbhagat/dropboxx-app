package in.drunkenbee.app.dropboxx;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import ss.com.bannerslider.Slider;


public class Home extends Fragment {

    private RecyclerView comboRecyclerView;
    private ComboRecyclerAdapter comboRecyclerAdapter;
    private Slider slider;

    public Home(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Slider.init(new BannerImageLoadingService(getActivity()));
        comboRecyclerView = view.findViewById(R.id.combo_recycler);
        slider = view.findViewById(R.id.banner_slider);

        ComboHandler comboHandler = new ComboHandler(getActivity());
        comboHandler.getComboList(new ComboHandlerCallback() {
            @Override
            public void onComboListAvailable(ArrayList<ComboAdapter> list) {

                comboRecyclerAdapter = new ComboRecyclerAdapter(getActivity(), list);

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

                comboRecyclerView.setNestedScrollingEnabled(false);
                comboRecyclerView.setLayoutManager(mLayoutManager);
                comboRecyclerView.setItemAnimator(new DefaultItemAnimator());
                comboRecyclerView.setAdapter(comboRecyclerAdapter);

            }

            @Override
            public void onBannerListAvailable(ArrayList<BannerAdapter> list) {

                Toast.makeText(getActivity(), "Setting Adapter for Banner", Toast.LENGTH_LONG).show();
                slider.setAdapter(new BannerSliderAdapter(getActivity(), list));
            }

            @Override
            public void onComboListError(String error) {
                Toast.makeText(getActivity(), "ERROR:"+error, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
