package com.solvd.delivery.serviceLayer;

import com.solvd.delivery.dao.IOrderDAO;
import com.solvd.delivery.bin.Customer;
import com.solvd.delivery.bin.Order;
import com.solvd.delivery.dao.impl.OrderDAO;

import java.sql.Date;
import java.util.List;

public class OrderService {

    IOrderDAO orderDAO = new OrderDAO();

    public List<Order> getOrderByUserID(int id) {
        return orderDAO.getAllForCustomer(id);
    }

    public void updateDeliveryDate(int id, Date date) {
        orderDAO.updateDeliveryDate(date, id);
    }


}
