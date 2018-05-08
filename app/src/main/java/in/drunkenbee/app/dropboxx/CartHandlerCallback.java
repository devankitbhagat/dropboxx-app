package in.drunkenbee.app.dropboxx;

import java.util.ArrayList;

/**
 * Created by ankit on 8/5/18.
 */

public interface CartHandlerCallback {

    void onCartAvailable(CartAdapter adapter);
    void onCartListError(String error);
}
