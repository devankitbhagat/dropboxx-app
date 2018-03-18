package in.drunkenbee.app.dropboxx;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by ankit on 16/3/18.
 */

public class Connection {

    private  Context context;

    public Connection(Context context)
    {
        this.context = context;
    }

    public Boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean con = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        return con;
    }
}
