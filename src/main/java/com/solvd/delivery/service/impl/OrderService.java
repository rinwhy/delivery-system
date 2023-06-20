package com.solvd.delivery.service.impl;

import com.solvd.delivery.dao.IOrderDAO;
import com.solvd.delivery.bin.Order;
import com.solvd.delivery.dao.impl.OrderDAO;
import com.solvd.delivery.service.IOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class OrderService implements IOrderService {

    private static final Logger LOGGER = LogManager.getLogger(com.solvd.delivery.service.mybatisimpl.OrderService.class);

    IOrderDAO orderDAO = new OrderDAO();

    @Override
    public Order getOrderByID(int id) {
        if (id > 0) {
            return orderDAO.getByID(id);
        } else LOGGER.warn("ID is invalid");
        return null;
    }

    public List<Order> getAllOrdersByCustomersID(int id) {
        if (id > 0) {
            return orderDAO.getAllForCustomer(id);
        } else LOGGER.warn("ID is invalid");
        return null;
    }

    public void updateDeliveryDate(int id, Date date) {
        if (id > 0) {
            orderDAO.updateDeliveryDate(date, id);
        } else LOGGER.warn("ID is invalid");
    }

    @Override
    public List<Order> getOrdersJoinCustomers() {
        return orderDAO.getOrdersJoinCustomers();
    }


}
