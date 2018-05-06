package in.drunkenbee.app.dropboxx;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yarolegovich.discretescrollview.DiscreteScrollView;

import co.ceryle.radiorealbutton.RadioRealButton;
import co.ceryle.radiorealbutton.RadioRealButtonGroup;

public class Tiffin extends Fragment {

    RadioRealButtonGroup RadioFoodGroup;
    RadioRealButtonGroup RadioPlanGroup;
    TiffinAdapter tiffinAdapter;
    DiscreteScrollView scrollView;
    TextView tiffinPrice;
    int tiffinPlan = 1;
    int tiffinType = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tiffin, container, false);

        RadioFoodGroup = (RadioRealButtonGroup) view.findViewById(R.id.foodType);
        RadioPlanGroup = (RadioRealButtonGroup) view.findViewById(R.id.tiffinPlan);
        scrollView = view.findViewById(R.id.picker);
        tiffinPrice = view.findViewById(R.id.price);

        TiffinHandler tiffinHandler = new TiffinHandler(getActivity());

        tiffinHandler.getTiffinOption(new TiffinHandlerCallback() {
            @Override
            public void onTiffinOption(TiffinAdapter adapter) {
                tiffinAdapter = adapter;
                TiffinRecyclerAdapter tiffinRecyclerAdapter = new TiffinRecyclerAdapter(getActivity(), adapter.getVegMeals());
                scrollView.setAdapter(tiffinRecyclerAdapter);
                setPrice();
            }

            @Override
            public void onTiffinOptionError(String error) {

            }
        });


        // onClickButton listener detects any click performed on buttons by touch
        RadioFoodGroup.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(RadioRealButton button, int position) {
                Toast.makeText(getActivity(), "Clicked! Position: " + position, Toast.LENGTH_SHORT).show();
                if(position == 0){
                    tiffinType = 1;
                    tiffinPrice.setText("Rs "+tiffinAdapter.getVegWeeklyPrice());
                    TiffinRecyclerAdapter tiffinRecyclerAdapter = new TiffinRecyclerAdapter(getActivity(), tiffinAdapter.getVegMeals());
                    scrollView.setAdapter(tiffinRecyclerAdapter);
                } else {
                    tiffinType = 2;
                    tiffinPrice.setText("Rs "+tiffinAdapter.getNonvegWeeklyPrice());
                    TiffinRecyclerAdapter tiffinRecyclerAdapter = new TiffinRecyclerAdapter(getActivity(), tiffinAdapter.getNonvegMeals());
                    scrollView.setAdapter(tiffinRecyclerAdapter);
                }
                setPrice();
            }
        });

        // onClickButton listener detects any click performed on buttons by touch
        RadioPlanGroup.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(RadioRealButton button, int position) {
                Toast.makeText(getActivity(), "Clicked! Position: " + position, Toast.LENGTH_SHORT).show();
                if(position == 0){
                    tiffinPlan = 1;
                } else {
                    tiffinPlan = 2;
                }
                setPrice();
            }
        });


        return view;
    }

    public void setPrice(){
        if(tiffinType == 1){
            if(tiffinPlan == 1){
                tiffinPrice.setText("Rs "+ tiffinAdapter.getVegWeeklyPrice());
            } else {
                tiffinPrice.setText("Rs "+ tiffinAdapter.getVegMonthlyPrice());
            }
        } else {
            if(tiffinPlan == 1){
                tiffinPrice.setText("Rs "+ tiffinAdapter.getNonvegWeeklyPrice());
            } else {
                tiffinPrice.setText("Rs "+ tiffinAdapter.getNonvegMonthlyPrice());
            }
        }
    }

}


