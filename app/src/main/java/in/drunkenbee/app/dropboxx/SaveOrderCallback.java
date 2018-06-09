package in.drunkenbee.app.dropboxx;

/**
 * Created by ankit on 9/6/18.
 */

public interface SaveOrderCallback {

    void onOrderSave(String msg);
    void onError(String error);
}
