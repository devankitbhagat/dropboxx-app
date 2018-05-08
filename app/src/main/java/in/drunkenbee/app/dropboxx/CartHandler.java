package in.drunkenbee.app.dropboxx;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ankit on 8/5/18.
 */

public class CartHandler {

    private Context context;
    private ArrayList<CartAdapter> cartArrayList;

    public CartHandler(Context context){
        this.context = context;
    }

    public void getCart(final CartHandlerCallback callback){

        UserPref userPref = new UserPref(context);
        String userId = userPref.getUserId();
        String accessToken = userPref.getUserAccessToken();

        String cartUrl = AppConfig.cartUrl()+"&user_id="+userId+"&access_token="+accessToken;

        Communicator communicator = new Communicator(context, cartUrl);
        communicator.communicate(new CommunicatorCallback() {
            @Override
            public void onSuccess(JSONObject result) {

                try {

                    int responseCode = result.getInt("responseCode");

                    if(responseCode == AppConfig.STATUS_OK){

                        JSONObject responseMsg = result.getJSONObject("responseMsg");
                        JSONArray orderList = responseMsg.getJSONArray("order_list");

                        ArrayList<CartProductAdapter> cartProductList = new ArrayList<CartProductAdapter>();
                        for (int i = 0; i < orderList.length(); i++ ){

                            CartProductAdapter cartProductAdapter = new CartProductAdapter();
                            JSONObject productDetail = orderList.getJSONObject(i);

                            cartProductAdapter.setProductName(productDetail.getString("product_name"));
                            cartProductAdapter.setProductImage(productDetail.getString("product_image"));
                            cartProductAdapter.setProductId(productDetail.getInt("product_id"));
                            cartProductAdapter.setProductCount(productDetail.getInt("product_count"));
                            cartProductAdapter.setType(productDetail.getInt("product_type"));
                            cartProductAdapter.setTotalPay(productDetail.getDouble("product_total_pay"));
                            cartProductAdapter.setUserOrderProductId(productDetail.getInt("user_order_product_id"));

                            cartProductList.add(cartProductAdapter);
                        }

                        CartAdapter cartAdapter = new CartAdapter();

                        cartAdapter.setOrderId(responseMsg.getInt("order_id"));
                        cartAdapter.setFinalPay(responseMsg.getDouble("total_pay"));
                        cartAdapter.setCartProductList(cartProductList);

                        callback.onCartAvailable(cartAdapter);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                    callback.onCartListError(e.toString());
                }

            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }

}
