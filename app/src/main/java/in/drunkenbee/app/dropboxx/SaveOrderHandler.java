package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ankit on 9/6/18.
 */

public class SaveOrderHandler {

    private Context context;

    public SaveOrderHandler(Context context){
        this.context = context;
    }

    public void saveCombo(int comboId,final SaveOrderCallback callback){

        UserPref userPref = new UserPref(context);
        String userId = userPref.getUserId();
        String accessToken = userPref.getUserAccessToken();
        Toast.makeText(context, "USER ID"+userId, Toast.LENGTH_LONG).show();
        String cartUrl = AppConfig.cartUrl()+"&user_id="+userId+"&access_token="+accessToken+"&count=1&combo_id="+comboId;

        Communicator communicator = new Communicator(context, cartUrl);

        communicator.communicate(new CommunicatorCallback() {
            @Override
            public void onSuccess(JSONObject result) {

                try {
                    int responseCode = result.getInt("responseCode");

                    if(responseCode == AppConfig.STATUS_OK){

                        callback.onOrderSave("Success");
                    } else {
                        callback.onError("Something went wrong!");
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                    callback.onError(e.toString());
                }
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }
}
