package com.solvd.delivery.dao;

import com.solvd.delivery.bin.Order;

import java.sql.Date;
import java.util.List;


public interface IOrderDAO extends DAO<Order>{

    List<Order> getOrdersJoinCustomers();
    List<Order> getAllForCustomer(int id);

    void updateDeliveryDate(Date date ,int id);
}
