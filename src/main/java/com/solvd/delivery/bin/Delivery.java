package com.solvd.delivery.bin;

import java.sql.Date;

public class Delivery extends BaseTable{

    private Date expectedDeliveryDate;
    private String status;
    private Driver driver;
    private Order order;

    public int getId() {
        return super.id;
    }

    public void setId(int id) {
        super.id = id;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDriverID() {
        return driver.getId();
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getOrderID() {
        return order.getId();
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
