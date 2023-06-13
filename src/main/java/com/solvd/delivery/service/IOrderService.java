package com.solvd.delivery.service;

import com.solvd.delivery.bin.Order;

import java.sql.Date;
import java.util.List;

public interface IOrderService {

    public List<Order> getOrderByUserID(int id);
    public void updateDeliveryDate(int id, Date date);
}
