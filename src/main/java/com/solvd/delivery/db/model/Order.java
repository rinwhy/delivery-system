package com.solvd.delivery.db.model;

import java.sql.Date;

public class Order {

    private int id;
    private Date orderDate;
    private Date deliveryDate;
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getCustomerID() {
        return customer.getId();
    }

    public void setCustomer(Customer customer) { this.customer = customer;}


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", customerID=" + customer.getId() +
                '}';
    }
}
