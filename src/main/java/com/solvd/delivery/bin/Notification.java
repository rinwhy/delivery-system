package com.solvd.delivery.bin;

import java.sql.Timestamp;

public class Notification extends BaseTable{

    private String message;
    private Timestamp timestamp;
    private Customer customer;
    private Delivery delivery;

    public int getId() {
        return super.id;
    }

    public void setId(int id) {
        super.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getCustomerID() {
        return customer.getId();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getDeliveryID() {
        return delivery.getId();
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
