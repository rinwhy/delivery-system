package com.solvd.delivery.bin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.Date;

@JsonPropertyOrder({ "id", "expectedDeliveryDate", "status", "driver", "order"})
public class Delivery {

    private int id;

    @JsonProperty("delivery date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date expectedDeliveryDate;

    private String status;
    private Driver driver;
    private Order order;

    public Delivery() {
    }

    public Delivery(Date expectedDeliveryDate, String status, Driver driver, Order order) {
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.status = status;
        this.driver = driver;
        this.order = order;
    }

    public Delivery(int id, Date expectedDeliveryDate, String status, Driver driver, Order order) {
        this.id = id;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.status = status;
        this.driver = driver;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", expectedDeliveryDate=" + expectedDeliveryDate +
                ", status='" + status + '\'' +
                ", driver=" + driver +
                ", order=" + order +
                '}';
    }
}
