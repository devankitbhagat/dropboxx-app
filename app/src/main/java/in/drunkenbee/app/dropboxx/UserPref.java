package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ankit on 18/3/18.
 */

public class UserPref {

    private Context context;
    private SharedPreferences sharedPreferences;

    public UserPref(Context context){
        this.context = context;
        this.sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getUserId(){
        return sharedPreferences.getString(AppConfig.USER_ID, null);
    }

    public void setUserid(String userId){
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(AppConfig.USER_ID, userId);
        prefEditor.commit();
    }

    public String getUserAccessToken(){
        return sharedPreferences.getString(AppConfig.ACCESS_TOKEN, null);
    }

    public void setUserAccessToken(String accessToken){
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(AppConfig.ACCESS_TOKEN, String.valueOf(accessToken));
        prefEditor.commit();
    }

    public String getDeviceUUID(){
        return sharedPreferences.getString(AppConfig.DEVICE_UUD, null);
    }

    public void setDeviceUUID(String deviceUUID){
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(AppConfig.DEVICE_UUD, deviceUUID);
        prefEditor.apply();
    }

    public String getUserPhoneNumber(){
        return sharedPreferences.getString(AppConfig.PHONE_NUMBER, null);
    }

    public void setUserPhoneNumber(String phoneNumber){
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(AppConfig.PHONE_NUMBER, phoneNumber);
        prefEditor.apply();
    }


}
