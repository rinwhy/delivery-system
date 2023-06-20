package com.solvd.delivery.bin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solvd.delivery.utils.jaxB.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order  {

    @XmlAttribute
    private int id;

    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date orderDate;

    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date deliveryDate;

    private Customer customer;

    public Order() {
    }

    public Order(Date orderDate, Date deliveryDate, Customer customer) {
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
    }

    public Order(int id, Date orderDate, Date deliveryDate, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) { this.customer = customer;}


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", customerID=" + customer.toString() +
                '}';
    }

}
