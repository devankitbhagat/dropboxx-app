package in.drunkenbee.app.dropboxx;

import java.util.ArrayList;

/**
 * Created by ankit on 10/6/18.
 */

public interface orderHistoryCallback {

    void onOrderHistoryAvailable(ArrayList<OrderHistoryAdapter> list);
    void onOrderHistoryError(String error);
}
