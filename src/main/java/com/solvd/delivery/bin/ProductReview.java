package com.solvd.delivery.bin;

import java.sql.Timestamp;

public class ProductReview extends BaseTable{

    private int rating;
    private String commentReview;
    private Timestamp timestamp;
    private Product product;
    private Customer customer;

    public int getId() {
        return super.id;
    }

    public void setId(int id) {
        super.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCommentReview() {
        return commentReview;
    }

    public void setCommentReview(String commentReview) {
        this.commentReview = commentReview;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getProductID() {
        return product.getId();
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCustomerID() {
        return customer.getId();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
