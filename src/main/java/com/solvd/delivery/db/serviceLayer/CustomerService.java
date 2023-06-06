package com.solvd.delivery.db.serviceLayer;

import com.solvd.delivery.db.interfacesDao.ICustomerDAO;
import com.solvd.delivery.db.model.Customer;
import com.solvd.delivery.db.mysql.dao.CustomerDAO;

import java.util.List;

public class CustomerService {

    ICustomerDAO customerDao = new CustomerDAO();

    public Customer getCustomerByID(int customerID) {
        return customerDao.getCustomerByID(customerID);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public void deleteCustomerByID(int id) {
        customerDao.deleteCustomerByID(id);
    }

}
