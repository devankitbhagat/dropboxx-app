package in.drunkenbee.app.dropboxx;

import java.util.ArrayList;

/**
 * Created by ankit on 30/4/18.
 */

interface ComboHandlerCallback {
    void onComboListAvailable(ArrayList<ComboAdapter> list);
    void onBannerListAvailable(ArrayList<BannerAdapter> list);
    void onComboListError(String error);
}
