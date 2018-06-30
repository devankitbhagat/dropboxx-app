package in.drunkenbee.app.dropboxx;

import java.util.ArrayList;

/**
 * Created by ankit on 10/6/18.
 */

public interface AddressListCallBack {

    void onAddressListAvailable(ArrayList<AddressAdapter> list);
    void onAddressListError(String error);
}
