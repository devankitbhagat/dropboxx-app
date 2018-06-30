package in.drunkenbee.app.dropboxx;

/**
 * Created by ankit on 10/6/18.
 */

public interface SaveAddressCallback {

    void onAddressSave(String msg);
    void onError(String error);

}
