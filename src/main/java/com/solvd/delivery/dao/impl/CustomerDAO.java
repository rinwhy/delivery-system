package com.solvd.delivery.dao.impl;

import com.solvd.delivery.dao.ICustomerDAO;
import com.solvd.delivery.bin.Customer;
import com.solvd.delivery.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO implements ICustomerDAO {

    private static final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);
    private static final ConnectionPool cp = ConnectionPool.getInstance();

    private static final String GET_BY_ID = "SELECT * FROM CUSTOMERS WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM CUSTOMERS";
    private static final String INSERT = "insert into Customers(name, address, email) VALUES (?,?,?)";
    private static final String DELETE = "DELETE FROM Customers WHERE id = ?";
    private static final String UPDATE = "UPDATE Customers SET name= ?, address= ?, email= ? WHERE id= ?";

    @Override
    public Customer getByID(int id) {

        Connection connection = cp.requestConnection();
        Customer customer = new Customer();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                customer.setId(results.getInt("id"));
                customer.setName(results.getString("name"));
                customer.setAddress(results.getString("address"));
                customer.setEmail(results.getString("email"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            closeResources(connection, ps);
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {

        Connection connection = cp.requestConnection();
        List<Customer> customerList = new ArrayList<>();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(GET_ALL);
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                Customer customer = new Customer();
                customer.setName(results.getString("name"));
                customer.setId(results.getInt("id"));
                customer.setAddress(results.getString("address"));
                customer.setEmail(results.getString("email"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            closeResources(connection, ps);
        }

        return customerList;
    }

    @Override
    public void insert(Customer customer) {

        Connection connection = cp.requestConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(INSERT);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            closeResources(connection, ps);
        }
    }

    @Override
    public void update(Customer customer, int id) {

        Connection connection = cp.requestConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(UPDATE);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getEmail());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            closeResources(connection, ps);
        }
    }

    @Override
    public void deleteByID(int id) {

        Connection connection = cp.requestConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            closeResources(connection, ps);
        }
    }

    private void closeResources(Connection connection, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cp.releaseConnection(connection);
    }

}

