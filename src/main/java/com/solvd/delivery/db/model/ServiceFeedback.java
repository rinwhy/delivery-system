package com.solvd.delivery.db.model;

import java.sql.Timestamp;

public class ServiceFeedback {

    private int id;
    private int deliveryRating;
    private int serviceRating;
    private String comment;
    private Timestamp timestamp;
    private Order order;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeliveryRating() {
        return deliveryRating;
    }

    public void setDeliveryRating(int deliveryRating) {
        this.deliveryRating = deliveryRating;
    }

    public int getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(int serviceRating) {
        this.serviceRating = serviceRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getOrderID() {
        return order.getId();
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
