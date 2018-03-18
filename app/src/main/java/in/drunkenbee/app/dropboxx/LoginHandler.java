package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;

/**
 * Created by ankit on 15/3/18.
 */

class LoginHandler {

    private Context context;
    private String loginUrl;
    private int statusCode;
    private String phoneNumber;
    private Integer loginType;
    private String deviceToken;

    public LoginHandler(Context context, Integer loginType, String phoneNumber, String deviceToken)
    {
        this.context = context;
        this.loginType = loginType;
        this.phoneNumber = phoneNumber;
        this.deviceToken = deviceToken;
    }

    public void login(final LoginCallback callback) {

        loginUrl = AppConfig.getLoginUrl()+"&type="+loginType+"&number="+phoneNumber+"&device_token="+deviceToken;
        Toast.makeText(context, loginUrl, Toast.LENGTH_LONG).show();
        Communicator communicator = new Communicator(context, loginUrl);
        communicator.communicate(new CommunicatorCallback() {
            @Override
            public void onSuccess(JSONObject responseObject) {
                try {
                    statusCode = responseObject.getInt("responseCode");
                    if(statusCode == AppConfig.STATUS_OK)
                    {
                        LoginAdapter loginAdapter = new LoginAdapter();
                        JSONObject loginData = responseObject.getJSONObject("responseMsg");
                        loginAdapter.setUserId(loginData.getInt("user_id"));
                        loginAdapter.setAccessToken(loginData.getString("access_token"));
                        callback.onLogin(loginAdapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }
}
