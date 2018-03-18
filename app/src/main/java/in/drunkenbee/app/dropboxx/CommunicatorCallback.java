package in.drunkenbee.app.dropboxx;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ankit on 12/3/18.
 */

public interface CommunicatorCallback {
    void onSuccess(JSONObject result);

    void onError(VolleyError error);
}
