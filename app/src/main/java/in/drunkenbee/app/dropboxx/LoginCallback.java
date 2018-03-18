package in.drunkenbee.app.dropboxx;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by ankit on 15/3/18.
 */

public interface LoginCallback {
     void onLogin(LoginAdapter adapter);

     void onError(String error);
}
