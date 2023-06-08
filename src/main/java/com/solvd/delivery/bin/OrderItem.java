package com.solvd.delivery.bin;

public class OrderItem extends BaseTable{

    private int quantity;
    private Order order;
    private Product product;

    public int getId() {
        return super.id;
    }

    public void setId(int id) {
        super.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderID() {
        return order.getId();
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getProductID() {
        return product.getId();
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
