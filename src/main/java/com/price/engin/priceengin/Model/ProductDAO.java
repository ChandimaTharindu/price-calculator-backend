package com.price.engin.priceengin.Model;

public class ProductDAO {
    private long productId;
    private  double qty;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
}
