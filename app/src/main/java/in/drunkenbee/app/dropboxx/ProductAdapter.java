package in.drunkenbee.app.dropboxx;

/**
 * Created by ankit on 30/4/18.
 */

public class ProductAdapter {

    private int productId;
    private String productName;
    private String productDescription;
    private String productImage;
    private double productPrice;

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public  void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductImage() {
        return productImage;
    }
}
