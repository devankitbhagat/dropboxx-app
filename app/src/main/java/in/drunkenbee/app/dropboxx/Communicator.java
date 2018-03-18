package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by ankit on 12/3/18.
 */

public class Communicator {

    String url;
    Context context;

    public Communicator(Context context, String url){
        this.context = context;
        this.url = url;
    }

    public void communicate(final CommunicatorCallback callback){

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("COMMUNICATOR RESPONSE:", response.toString());
                callback.onSuccess(response);
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("COMMUNICATOR ERROR:", error.toString());
                callback.onError(error);
            }
        });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(60000,5,2));
        requestQueue.add(jsonObjectRequest);
    }
}
