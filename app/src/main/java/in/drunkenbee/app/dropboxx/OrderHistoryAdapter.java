package in.drunkenbee.app.dropboxx;

/**
 * Created by ankit on 10/6/18.
 */

public class OrderHistoryAdapter {

    private int orderId;
    private String orderDate;
    private double totalPay;
    private String products;
    private int status;

    private static final int ORDER_STATUS_CONFIRMED = 1;
    private static final int ORDER_STATUS_DELIVERED = 2;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getProducts() {
        return products;
    }

    public String getStatus() {
        if (this.status == ORDER_STATUS_CONFIRMED)
            return "ORDER CONFIRMED";
        else
            return "ORDER_DELIVERED";
    }
}
