package in.drunkenbee.app.dropboxx;

import java.util.ArrayList;

/**
 * Created by ankit on 8/5/18.
 */

public class CartAdapter {

    private int orderId;
    private double finalPay;
    private ArrayList<CartProductAdapter> cartProductList;

    public void setCartProductList(ArrayList<CartProductAdapter> cartProductList) {
        this.cartProductList = cartProductList;
    }

    public void setFinalPay(double finalPay) {
        this.finalPay = finalPay;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<CartProductAdapter> getCartProductList() {
        return cartProductList;
    }

    public double getFinalPay() {
        return finalPay;
    }

    public int getOrderId() {
        return orderId;
    }
}
