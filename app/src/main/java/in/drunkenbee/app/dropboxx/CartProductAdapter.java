package in.drunkenbee.app.dropboxx;

/**
 * Created by ankit on 8/5/18.
 */

public class CartProductAdapter {

    private String productName;
    private int productId;
    private int type;
    private int userOrderProductId;
    private String productImage;
    private int productCount;
    private double totalPay;

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setUserOrderProductId(int userOrderProductId) {
        this.userOrderProductId = userOrderProductId;
    }

    public int getUserOrderProductId() {
        return userOrderProductId;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public int getProductCount() {
        return productCount;
    }

    public int getProductId() {
        return productId;
    }

    public int getType() {
        return type;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }
}
