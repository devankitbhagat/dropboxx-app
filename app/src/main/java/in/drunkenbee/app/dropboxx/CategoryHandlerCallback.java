package in.drunkenbee.app.dropboxx;

import java.util.ArrayList;

/**
 * Created by ankit on 30/4/18.
 */

public interface CategoryHandlerCallback {
    void onCategoryListAvailable(ArrayList<CategoryAdapter> list);
    void onCategoryListError(String error);
}
