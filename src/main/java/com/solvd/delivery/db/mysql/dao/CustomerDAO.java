package com.solvd.delivery.db.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.delivery.db.mysql.connection.ConnectionPool;
import com.solvd.delivery.db.interfacesDao.ICustomerDAO;
import com.solvd.delivery.db.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO implements ICustomerDAO {

    public static final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);

    @Override
    public Customer getCustomerByID(int id) {

        Connection connection = ConnectionPool.getConnection();
        Customer customer = new Customer();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMERS WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                customer.setId(results.getInt("id"));
                customer.setName(results.getString("name"));
                customer.setAddress(results.getString("address"));
                customer.setEmail(results.getString("email"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {

        Connection connection = ConnectionPool.getConnection();
        List<Customer> customerList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMERS");
            ResultSet results = preparedStatement.executeQuery();
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
        }

        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        Connection connection = ConnectionPool.getConnection();
        String statement = "insert into Customers(name, address, email) VALUES (?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
    }

    @Override
    public void deleteCustomerByID(int id) {

        Connection connection = ConnectionPool.getConnection();
        String statement = "DELETE FROM Customers WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
    }
}

