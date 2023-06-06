package com.solvd.delivery.db.interfacesDao;

import com.solvd.delivery.db.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {

        Customer getCustomerByID(int id);
        List<Customer> getAllCustomers();
        void addCustomer(Customer customer);
        void deleteCustomerByID(int id);
}
