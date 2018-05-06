package in.drunkenbee.app.dropboxx;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ankit on 30/4/18.
 */

public class CategoryHandler {

    private Context context;
    private ArrayList<CategoryAdapter> parsedCategoryList = new ArrayList<CategoryAdapter>();

    public CategoryHandler(Context context){
        this.context = context;
    }

    public void getCategoryList(final CategoryHandlerCallback callback){

        UserPref userPref = new UserPref(context);
        String userId = userPref.getUserId();
        String accessToken = userPref.getUserAccessToken();

        String categoryListUrl = AppConfig.categoryListUrl()+"&user_id="+userId+"&access_token="+accessToken;
        Communicator communicator = new Communicator(context, categoryListUrl);

        communicator.communicate(new CommunicatorCallback() {
            @Override
            public void onSuccess(JSONObject result) {

                try {

                    int responseCode = result.getInt("responseCode");
                    JSONObject responseMsg = result.getJSONObject("responseMsg");
                    JSONArray categoryList = responseMsg.getJSONArray("category_list");

                    for (int i = 0; i < categoryList.length(); i++){

                        CategoryAdapter categoryAdapter = new CategoryAdapter();
                        ArrayList<ProductAdapter> parsedProductList = new ArrayList<ProductAdapter>();
                        JSONObject category = categoryList.getJSONObject(i);

                        categoryAdapter.setCategoryId(category.getInt("master_category_id"));
                        categoryAdapter.setCategoryName(category.getString("category_name"));
                        categoryAdapter.setCategoryImage(category.getString("category_image"));

                        JSONArray productList = category.getJSONArray("product_list");

                        for (int j = 0; j < productList.length(); j++){

                            ProductAdapter productAdapter = new ProductAdapter();
                            JSONObject product = productList.getJSONObject(j);

                            productAdapter.setProductId(product.getInt("master_product_id"));
                            productAdapter.setProductName(product.getString("product_name"));
                            productAdapter.setProductDescription(product.getString("product_description"));
                            productAdapter.setProductImage(product.getString("product_image"));

                            parsedProductList.add(productAdapter);

                        }

                        categoryAdapter.setCategoryProductList(parsedProductList);

                        parsedCategoryList.add(categoryAdapter);
                    }

                    callback.onCategoryListAvailable(parsedCategoryList);
                } catch (JSONException e) {
                    e.printStackTrace();

                    callback.onCategoryListError(e.toString());
                }
            }

            @Override
            public void onError(VolleyError error) {
                callback.onCategoryListError(error.getMessage());
            }
        });
    }
}
