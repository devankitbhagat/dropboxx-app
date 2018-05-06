package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ankit on 20/3/18.
 */

public class TiffinHandler {
    private HashMap<String, ArrayList<String>> tiffinType = new HashMap<String, ArrayList<String>>();
    private HashMap<String, ArrayList<String>> days = new HashMap<String, ArrayList<String>>();
    private Context context;

    public TiffinHandler(Context context){
        this.context = context;
    }

    public void getTiffinOption(final TiffinHandlerCallback callback){
        UserPref userPref = new UserPref(context);
        String userId = userPref.getUserId();
        String accessToken = userPref.getUserAccessToken();

        String tiffinOptionUrl = AppConfig.tiffinOptionUrl()+"&user_id="+userId+"&access_token="+accessToken;
        Communicator communicator = new Communicator(context, tiffinOptionUrl);
        communicator.communicate(new CommunicatorCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                Toast.makeText(context, result.toString(), Toast.LENGTH_LONG).show();

                TiffinAdapter tiffinAdapter = new TiffinAdapter();;
                int statusCode = 0;
                try {
                    statusCode = result.getInt("responseCode");
                    if(statusCode == AppConfig.STATUS_OK)
                    {
                        JSONArray tiffinOptions = result.getJSONObject("responseMsg").names();

                        for (int k = 0; k < tiffinOptions.length(); k ++)
                        {
//                            Log.e("LENGTH:", String.valueOf(tiffinOptions.length()));
//                            Log.e("K:", String.valueOf(k));
//                            Log.e("FOODTYPE:", tiffinOptions.getString(k));
                            String foodType = tiffinOptions.getString(k);
                            JSONObject tiffinData = result.getJSONObject("responseMsg").getJSONObject(foodType);

                            HashMap<String, ArrayList<String>> foodItemsHashMap = new HashMap<String, ArrayList<String>>();
                            JSONArray daysAvailable = tiffinData.getJSONObject("meal").names();


                            for(int i =0; i < daysAvailable.length(); i++)
                            {
//                                Log.e("DAY:", daysAvailable.getString(i));
                                String day = daysAvailable.getString(i);
                                JSONArray foodItems = tiffinData.getJSONObject("meal").getJSONArray(day);

                                ArrayList<String> item = new ArrayList<String>();

                                for (int j = 0; j < foodItems.length(); j++)
                                {
                                    item.add(foodItems.getString(j));
//                                    Log.e("FOODITEM:", foodItems.getString(j));
                                }

                                foodItemsHashMap.put(day, item);
                            }


                            Log.e("FOOD TYPE:",foodType);
                            if(foodType.equals("veg")){
                                Log.e("INSIDE VEG", foodType);
                                tiffinAdapter.setMonthlyMealCount(tiffinData.getJSONObject("detail").getInt("monthly_meal_count"));
                                tiffinAdapter.setWeeklyMealCount(tiffinData.getJSONObject("detail").getInt("weekly_meal_count"));
                                tiffinAdapter.setVegMonthlyPrice(tiffinData.getJSONObject("detail").getInt("monthly_price"));
                                tiffinAdapter.setVegWeeklyPrice(tiffinData.getJSONObject("detail").getInt("weekly_price"));
                                tiffinAdapter.setVegTiffinId(tiffinData.getJSONObject("detail").getInt("tiffin_id"));
                                tiffinAdapter.setVegMeals(foodItemsHashMap);
                                Log.e("VEG SIZE", String.valueOf(foodItemsHashMap.size()));
                            } else {
                                Log.e("INSIDE NON VEG", foodType);
                                tiffinAdapter.setNonvegMonthlyPrice(tiffinData.getJSONObject("detail").getInt("monthly_price"));
                                tiffinAdapter.setNonvegWeeklyPrice(tiffinData.getJSONObject("detail").getInt("weekly_price"));
                                tiffinAdapter.setNonvegTiffinId(tiffinData.getJSONObject("detail").getInt("tiffin_id"));
                                tiffinAdapter.setNonvegMeals(foodItemsHashMap);
                            }

                        }
                        tiffinAdapter.getVegMeals();
                        callback.onTiffinOption(tiffinAdapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    callback.onTiffinOptionError(e.toString());
                }
            }

            @Override
            public void onError(VolleyError error) {
                callback.onTiffinOptionError(error.toString());
            }
        });
    }
}
