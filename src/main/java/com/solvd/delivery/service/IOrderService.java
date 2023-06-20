package com.solvd.delivery.service;

import com.solvd.delivery.bin.Order;

import java.sql.Date;
import java.util.List;

public interface IOrderService {

    List<Order> getOrdersJoinCustomers();
    Order getOrderByID(int id);
    List<Order> getAllOrdersByCustomersID(int id);
    void updateDeliveryDate(int id, Date date);
}
