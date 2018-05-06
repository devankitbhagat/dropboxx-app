package in.drunkenbee.app.dropboxx;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ankit on 30/4/18.
 */

public class ComboHandler {

    private ArrayList<ComboAdapter> parsedComboList = new ArrayList<ComboAdapter>();
    private ArrayList<BannerAdapter> parsedBannerList = new ArrayList<BannerAdapter>();
    private Context context;

    public ComboHandler(Context context){
        this.context = context;
    }

    public void getComboList(final ComboHandlerCallback callback){

        UserPref userPref = new UserPref(context);
        String userId = userPref.getUserId();
        String accessToken = userPref.getUserAccessToken();

        String comboListUrl = AppConfig.comboListUrl()+"&user_id="+userId+"&access_token="+accessToken;
        Communicator communicator = new Communicator(context, comboListUrl);

        communicator.communicate(new CommunicatorCallback() {
            @Override
            public void onSuccess(JSONObject result) {

                try {

                    int responseCode = result.getInt("responseCode");

                    if(responseCode == AppConfig.STATUS_OK)
                    {

                        JSONObject responseMsg = result.getJSONObject("responseMsg");
                        JSONArray comboList = responseMsg.getJSONArray("combo_list");

                        for( int i = 0; i < comboList.length(); i ++)
                        {
                            ComboAdapter comboAdapter = new ComboAdapter();
                            JSONObject combo = comboList.getJSONObject(i);

                            comboAdapter.setComboId(combo.getInt("master_combo_id"));
                            comboAdapter.setComboName(combo.getString("combo_name"));
                            comboAdapter.setComboDescription(combo.getString("combo_description"));
                            comboAdapter.setComboImage(combo.getString("combo_image"));
                            comboAdapter.setComboPrice(combo.getString("combo_price"));

                            parsedComboList.add(comboAdapter);

                        }

                        JSONArray bannerList = responseMsg.getJSONArray("banner_list");

                        for( int i = 0; i < bannerList.length(); i ++)
                        {
                            BannerAdapter bannerAdapter = new BannerAdapter();
                            JSONObject banner = bannerList.getJSONObject(i);

                            bannerAdapter.setBannerName(banner.getString("banner_name"));
                            bannerAdapter.setBannerImage(banner.getString("image"));

                            parsedBannerList.add(bannerAdapter);

                        }


                        callback.onBannerListAvailable(parsedBannerList);
                        callback.onComboListAvailable(parsedComboList);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    callback.onComboListError(e.getMessage());
                }


            }

            @Override
            public void onError(VolleyError error) {
                callback.onComboListError(error.getMessage());
            }
        });


    }
}
