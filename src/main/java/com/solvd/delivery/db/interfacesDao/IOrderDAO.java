package com.solvd.delivery.db.interfacesDao;

import com.solvd.delivery.db.model.Customer;
import com.solvd.delivery.db.model.Order;

import java.sql.Date;
import java.util.List;

public interface IOrderDAO {

    List<Order> getOrderByUserID(int id);

    void updateDeliveryDate(int id, Date date);

    Customer getCustomerByOrderID(int id);


}
