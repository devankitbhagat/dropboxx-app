package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.UUID;

public class Splash extends AppCompatActivity {

    String deviceUUID;
    String phoneNumber;
    private Connection connection;
    private UserPref userPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        connection = new Connection(Splash.this);
        userPref = new UserPref(Splash.this);

        //Check for internet connectivity
        if(!connection.isConnected())
            Toast.makeText(Splash.this, "You are not connected to internet", Toast.LENGTH_LONG).show();


        deviceUUID = userPref.getDeviceUUID();
        phoneNumber = userPref.getUserPhoneNumber();


        //If internet connection is available try to login
        if(connection.isConnected()){
            //check for new user
            if(phoneNumber != null && deviceUUID != null) {
                //For first time login get the device UUID for guest login
                deviceUUID = UUID.randomUUID().toString();
                userPref.setDeviceUUID(deviceUUID);
            }

            LoginHandler loginHandler = new LoginHandler(Splash.this, AppConfig.LOGIN_TYPE_UUID, phoneNumber, deviceUUID);
            loginHandler.login(new LoginCallback() {
                @Override
                public void onLogin(LoginAdapter adapter) {
                    userPref.setUserid(String.valueOf(adapter.getUserId()));
                    userPref.setUserAccessToken(adapter.getAccessToken());

                    Toast.makeText(Splash.this, "Login Success! userId="+adapter.getUserId(), Toast.LENGTH_LONG).show();


                    new Handler().postDelayed(new Runnable(){

                        @Override
                        public void run() {
                            startActivity(new Intent(Splash.this, MainActivity.class));
                            finish();
                        }
                    }, 3000);

                }

                @Override
                public void onError(String error) {
                    Toast.makeText(Splash.this, "Login Error", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
