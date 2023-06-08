package com.solvd.delivery.bin;

import java.sql.Date;

public class Order extends BaseTable{

    private Date orderDate;
    private Date deliveryDate;
    private Customer customer;

    public int getId() {
        return super.id;
    }

    public void setId(int id) {
        super.id = id;
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
                "id=" + super.id +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", customerID=" + customer.getId() +
                '}';
    }
}
