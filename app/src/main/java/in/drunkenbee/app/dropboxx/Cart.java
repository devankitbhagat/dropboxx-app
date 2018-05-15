package in.drunkenbee.app.dropboxx;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Cart extends Fragment {

    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    CartRecyclerAdapter cartRecyclerAdapter;
    TextView finalPay;
    TextView orderId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = view.findViewById(R.id.cart_recycler);
        finalPay = view.findViewById(R.id.total_pay);
        orderId = view.findViewById(R.id.order_id);



        CartHandler cartHandler = new CartHandler(getActivity());

        cartHandler.getCart(new CartHandlerCallback() {
            @Override
            public void onCartAvailable(CartAdapter adapter) {

                finalPay.setText("YOU PAY: "+String.valueOf(adapter.getFinalPay()));
                orderId.setText("ORDER ID: "+String.valueOf(adapter.getOrderId()));

                if(adapter.getCartProductList().size() > 0)
                {
                    cartRecyclerAdapter = new CartRecyclerAdapter(getActivity(), adapter.getCartProductList());

                    LinearLayoutManager layoutManager
                            = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

                    recyclerView.setNestedScrollingEnabled(false);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(cartRecyclerAdapter);
                } else {
                    Toast.makeText(getActivity(), "NO ORDER FOUND!", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCartListError(String error) {

            }
        });

        return view;
    }
}
