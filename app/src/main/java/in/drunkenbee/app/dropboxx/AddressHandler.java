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

public class AddressHandler {

    private Context context;
    private ArrayList<AddressAdapter> list = new ArrayList<AddressAdapter>();

    public AddressHandler(Context context){
        this.context = context;
    }

    public void getAddressList(final AddressListCallBack callBack){

        UserPref userPref = new UserPref(context);
        String userId = userPref.getUserId();
        String accessToken = userPref.getUserAccessToken();

        String addressListUrl = AppConfig.getAddressListUrl()+"&user_id="+userId+"&access_token="+accessToken;
        Communicator communicator = new Communicator(context, addressListUrl);

        communicator.communicate(new CommunicatorCallback() {
            @Override
            public void onSuccess(JSONObject result) {

                try {

                    int responseCode = result.getInt("responseCode");

                    if(responseCode == AppConfig.STATUS_OK)
                    {
                        JSONObject responseMsg = result.getJSONObject("responseMsg");
                        JSONArray addressList = responseMsg.getJSONArray("address_list");

                        for (int i = 0; i < addressList.length(); i++){

                            AddressAdapter addressAdapter = new AddressAdapter();
                            JSONObject userAddress =addressList.getJSONObject(i);

                            addressAdapter.setAddressId(userAddress.getInt("user_address_id"));
                            addressAdapter.setAddressType(userAddress.getInt("address_type"));
                            addressAdapter.setPinCode(userAddress.getInt("pin_code"));
                            addressAdapter.setAddress(userAddress.getString("address"));

                            list.add(addressAdapter);
                        }

                        callBack.onAddressListAvailable(list);
                    } else {
                        callBack.onAddressListError(result.getString("responseInfo"));
                    }

                } catch (JSONException e) {
                    callBack.onAddressListError(e.toString());
                }

            }

            @Override
            public void onError(VolleyError error) {
                callBack.onAddressListError(error.toString());
            }
        });
    }

    public void saveAddress(int pinCode, String address, int addressType, final SaveAddressCallback callback){

        UserPref userPref = new UserPref(context);
        String userId = userPref.getUserId();
        String accessToken = userPref.getUserAccessToken();

        String addressSaveUrl = AppConfig.getAddressSaveUrl()+"&user_id="+userId+"&access_token="+accessToken;
        addressSaveUrl += "&address_type="+addressType;
        addressSaveUrl += "&pin_code="+pinCode;
        addressSaveUrl += "&address="+address;

        Communicator communicator = new Communicator(context, addressSaveUrl);

        communicator.communicate(new CommunicatorCallback() {
            @Override
            public void onSuccess(JSONObject result) {

                int responseCode = 0;
                try {
                    responseCode = result.getInt("responseCode");

                    if(responseCode == AppConfig.STATUS_OK) {
                        callback.onAddressSave("Saved");
                    } else {
                        callback.onError(result.getString("responseInfo"));
                    }

                } catch (JSONException e) {
                    callback.onError(e.toString());
                }


            }

            @Override
            public void onError(VolleyError error) {
                error.toString();
            }
        });
    }

    public void modifyAddress(int addressId, int pinCode, String address, int addressType, final SaveAddressCallback callback){

        UserPref userPref = new UserPref(context);
        String userId = userPref.getUserId();
        String accessToken = userPref.getUserAccessToken();

        String addressModifyUrl = AppConfig.getAddressSaveUrl()+"&user_id="+userId+"&access_token="+accessToken;
        addressModifyUrl += "&user_address_id="+addressId;
        addressModifyUrl += "&address_type="+addressType;
        addressModifyUrl += "&pin_code="+pinCode;
        addressModifyUrl += "&address="+address;

        Communicator communicator = new Communicator(context, addressModifyUrl);

        communicator.communicate(new CommunicatorCallback() {
            @Override
            public void onSuccess(JSONObject result) {

                int responseCode = 0;
                try {
                    responseCode = result.getInt("responseCode");

                    if(responseCode == AppConfig.STATUS_OK) {
                        callback.onAddressSave("Saved");
                    } else {
                        callback.onError(result.getString("responseInfo"));
                    }

                } catch (JSONException e) {
                    callback.onError(e.toString());
                }


            }

            @Override
            public void onError(VolleyError error) {
                error.toString();
            }
        });
    }


}
