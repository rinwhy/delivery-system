package com.solvd.delivery.db.mysql.dao;

import com.solvd.delivery.db.mysql.connection.ConnectionPool;
import com.solvd.delivery.db.interfacesDao.ICustomerDAO;
import com.solvd.delivery.db.model.Customer;

import java.sql.*;


public class CustomerDAO implements ICustomerDAO {

    @Override
    public Customer getUserByID(int id) throws SQLException {

        Customer customer = new Customer();
        Connection connection = ConnectionPool.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMERS WHERE customer_id=?");
            preparedStatement.setInt(1, id);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                customer.setName(results.getString("customer_name"));
                customer.setId(results.getInt("customer_id"));
            }
        return customer;
    }

}
