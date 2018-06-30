package in.drunkenbee.app.dropboxx;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ankit on 10/6/18.
 */

public class OrderHistoryHandler {

    private Context context;
    private ArrayList<OrderHistoryAdapter> list = new ArrayList<OrderHistoryAdapter>();

    public OrderHistoryHandler(Context context){
        this.context = context;
    }

    public void getOrderHistory(final orderHistoryCallback callback){

        UserPref userPref = new UserPref(context);
        String userId = userPref.getUserId();
        String accessToken = userPref.getUserAccessToken();

        String orderHistoryUrl = AppConfig.getOrderHistoryUrl()+"&user_id="+userId+"&access_token="+accessToken;
        Communicator communicator = new Communicator(context, orderHistoryUrl);

        communicator.communicate(new CommunicatorCallback() {
            @Override
            public void onSuccess(JSONObject result) {

                int responseCode = 0;

                try {

                    responseCode = result.getInt("responseCode");

                    if(responseCode == AppConfig.STATUS_OK) {

                        JSONObject responseMsg = result.getJSONObject("responseMsg");
                        JSONArray historyList = responseMsg.getJSONArray("history_list");

                        for (int i = 0; i < historyList.length(); i++){

                            OrderHistoryAdapter adapter = new OrderHistoryAdapter();
                            JSONObject history = historyList.getJSONObject(i);

                            adapter.setOrderId(history.getInt("user_order_id"));
                            adapter.setOrderDate(history.getString("order_confirm_date"));
                            adapter.setTotalPay(history.getDouble("total_pay"));
                            adapter.setProducts(history.getString("product_list"));
                            adapter.setStatus(history.getInt("status"));

                            list.add(adapter);

                        }

                        callback.onOrderHistoryAvailable(list);

                    } else {
                        callback.onOrderHistoryError(result.getString("responseInfo"));
                    }

                } catch (JSONException e) {
                    callback.onOrderHistoryError(e.toString());
                }
            }

            @Override
            public void onError(VolleyError error) {
                callback.onOrderHistoryError(error.toString());
            }
        });
    }
}
