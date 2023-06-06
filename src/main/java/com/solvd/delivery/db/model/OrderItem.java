package com.solvd.delivery.db.model;

public class OrderItem {

    private int id;
    private int quantity;
    private Order order;
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
