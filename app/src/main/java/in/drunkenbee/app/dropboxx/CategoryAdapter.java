package in.drunkenbee.app.dropboxx;

import java.util.ArrayList;

/**
 * Created by ankit on 30/4/18.
 */

public class CategoryAdapter {

    private int categoryId;
    private String categoryName;
    private String categoryImage;
    private ArrayList<ProductAdapter> categoryProductList;

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryProductList(ArrayList<ProductAdapter> categoryProductList) {
        this.categoryProductList = categoryProductList;
    }

    public ArrayList<ProductAdapter> getCategoryProductList() {
        return categoryProductList;
    }
}
