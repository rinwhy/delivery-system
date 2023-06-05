package com.solvd.delivery.db.serviceLayer;

import com.solvd.delivery.db.interfacesDao.ICustomerDAO;
import com.solvd.delivery.db.model.Customer;
import com.solvd.delivery.db.mysql.dao.CustomerDAO;

import java.sql.SQLException;

public class CustomerService {

    public Customer getCustomer(int customerID) {
        ICustomerDAO customerDao = new CustomerDAO();

        return null;

    }


    public static void main(String[] args) throws SQLException {
        Customer customer = new CustomerDAO().getUserByID(9);
        System.out.println(customer);
    }
}
