package in.drunkenbee.app.dropboxx;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;

import ss.com.bannerslider.Slider;


public class Home extends Fragment {

    private RecyclerView comboRecyclerView;
    private ComboRecyclerAdapter comboRecyclerAdapter;
    CategoryRecyclerAdapter categoryRecyclerAdapter;
    DiscreteScrollView scrollView;
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
        scrollView = view.findViewById(R.id.category_recycler);

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

        CategoryHandler categoryHandler = new CategoryHandler(getActivity());

        categoryHandler.getCategoryList(new CategoryHandlerCallback() {
            @Override
            public void onCategoryListAvailable(ArrayList<CategoryAdapter> list) {
                Toast.makeText(getActivity(), list.get(0).getCategoryName(), Toast.LENGTH_LONG).show();

                categoryRecyclerAdapter = new CategoryRecyclerAdapter(getActivity(), list);

                InfiniteScrollAdapter wrapper = InfiniteScrollAdapter.wrap(categoryRecyclerAdapter);

                scrollView.setItemTransformer(new ScaleTransformer.Builder()
                        .setMaxScale(1.05f)
                        .setMinScale(0.8f)
                        .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                        .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                        .build());

                scrollView.setAdapter(wrapper);

            }

            @Override
            public void onCategoryListError(String error) {
                Toast.makeText(getActivity(), "ERROR: "+ error, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
