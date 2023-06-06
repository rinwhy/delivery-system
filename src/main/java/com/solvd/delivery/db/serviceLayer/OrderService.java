package com.solvd.delivery.db.serviceLayer;

import com.solvd.delivery.db.interfacesDao.IOrderDAO;
import com.solvd.delivery.db.model.Customer;
import com.solvd.delivery.db.model.Order;
import com.solvd.delivery.db.mysql.dao.OrderDAO;

import java.sql.Date;
import java.util.List;

public class OrderService {

    IOrderDAO orderDAO = new OrderDAO();

    public List<Order> getOrderByUserID(int id) {
        return orderDAO.getOrderByUserID(id);
    }

    public void updateDeliveryDate(int id, Date date) {
        orderDAO.updateDeliveryDate(id, date);
    }

    public Customer getCustomerByOrderID(int id) {
        return orderDAO.getCustomerByOrderID(id);
    }

}
