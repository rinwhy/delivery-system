package com.solvd.delivery.dao.impl;

import com.solvd.delivery.dao.ICustomerDAO;
import com.solvd.delivery.dao.IOrderDAO;
import com.solvd.delivery.bin.Order;
import com.solvd.delivery.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    public static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);
    private static final ConnectionPool cp = ConnectionPool.getInstance();

    private static final String GET_BY_ID = "SELECT * FROM Orders WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM Orders";
    private static final String GET_ALL_BY_CUSTOMER_ID = "SELECT * FROM Orders WHERE customer_id=?";
    private static final String INSERT = "INSERT INTO Orders (order_date, delivery_date, customer_id) VALUES (?,?,?)";
    private static final String DELETE = "DELETE FROM Orders WHERE id = ?";
    private static final String UPDATE = "UPDATE Orders SET order_date= ?, delivery_date= ?, customer_id= ? WHERE id= ?";
    private static final String UPDATE_DELIVERY_DATE = "UPDATE orders SET delivery_date = ? WHERE id = ?";


    @Override
    public Order getByID(int id) {

        Connection connection = cp.requestConnection();
        Order order = new Order();
        ICustomerDAO customerDAO = new CustomerDAO();

        try (PreparedStatement ps = connection.prepareStatement(GET_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet results = ps.executeQuery()) {
                while (results.next()) {
                    order.setId(results.getInt("id"));
                    order.setOrderDate(results.getDate("order_date"));
                    order.setDeliveryDate(results.getDate("delivery_date"));
                    order.setCustomer(customerDAO.getByID(results.getInt("customer_id")));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
        return order;
    }

    @Override
    public List<Order> getAll() {

        Connection connection = cp.requestConnection();
        List<Order> orderList = new ArrayList<>();
        ICustomerDAO customerDAO = new CustomerDAO();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL)) {
            try (ResultSet results = ps.executeQuery()) {
                while (results.next()) {
                    Order order = new Order();
                    order.setId(results.getInt("id"));
                    order.setOrderDate(results.getDate("order_date"));
                    order.setDeliveryDate(results.getDate("delivery_date"));
                    order.setCustomer(customerDAO.getByID(results.getInt("customer_id")));
                    orderList.add(order);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
        return orderList;
    }

    @Override
    public void insert(Order order) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setDate(1, order.getOrderDate());
            ps.setDate(2, order.getDeliveryDate());
            ps.setInt(3, order.getCustomer().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

    @Override
    public void update(Order order, int id) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setDate(1, order.getOrderDate());
            ps.setDate(2, order.getDeliveryDate());
            ps.setInt(3, order.getCustomer().getId());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int id) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

    @Override
    public List<Order> getAllForCustomer(int id) {

        Connection connection = cp.requestConnection();
        List<Order> orderList = new ArrayList<>();
        ICustomerDAO customerDAO = new CustomerDAO();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_BY_CUSTOMER_ID)) {
            ps.setInt(1, id);
            try (ResultSet results = ps.executeQuery()) {
                while (results.next()) {
                    Order order = new Order();
                    order.setId(results.getInt("id"));
                    order.setOrderDate(results.getDate("order_date"));
                    order.setDeliveryDate(results.getDate("delivery_date"));
                    order.setCustomer(customerDAO.getByID(results.getInt("customer_id")));
                    orderList.add(order);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
        return orderList;
    }

    @Override
    public void updateDeliveryDate(Date date, int id) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_DELIVERY_DATE)) {
            ps.setDate(1, date);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

}
