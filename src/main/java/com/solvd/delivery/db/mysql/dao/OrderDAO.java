package com.solvd.delivery.db.mysql.dao;

import com.solvd.delivery.db.interfacesDao.IOrderDAO;
import com.solvd.delivery.db.model.Customer;
import com.solvd.delivery.db.model.Order;
import com.solvd.delivery.db.mysql.connection.ConnectionPool;
import com.solvd.delivery.db.serviceLayer.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    public static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);

    @Override
    public List<Order> getOrderByUserID(int id) {
        Connection connection = ConnectionPool.getConnection();

        List<Order> orderList = new ArrayList<>();
        CustomerService cs = new CustomerService();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE customer_id=?");
            preparedStatement.setInt(1, id);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                Order order = new Order();
                order.setId(results.getInt("id"));
                order.setOrderDate(results.getDate("order_date"));
                order.setDeliveryDate(results.getDate("delivery_date"));
                order.setCustomer(cs.getCustomerByID(results.getInt("customer_id")));
                orderList.add(order);
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
        return orderList;
    }

    @Override
    public void updateDeliveryDate(int id, Date date) {
        Connection connection = ConnectionPool.getConnection();
        String statement = "UPDATE orders SET delivery_date = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setDate(1, date);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
    }

    @Override
    public Customer getCustomerByOrderID(int id) {
        Connection connection = ConnectionPool.getConnection();
        String statement = "SELECT customer_id FROM orders WHERE id = ?;";

        Customer customer = new Customer();
        CustomerService cs = new CustomerService();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();

            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                customer = cs.getCustomerByID(results.getInt("customer_id"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }

        return customer;
    }
}
