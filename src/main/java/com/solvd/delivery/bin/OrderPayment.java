package com.solvd.delivery.bin;

public class OrderPayment extends BaseTable{

    private String paymentMethod;
    private double totalAmount;
    private Order order;

    public int getId() {
        return super.id;
    }

    public void setId(int id) {
        super.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getOrderID() {
        return order.getId();
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
