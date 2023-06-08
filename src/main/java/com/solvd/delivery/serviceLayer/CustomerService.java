package com.solvd.delivery.serviceLayer;

import com.solvd.delivery.dao.ICustomerDAO;
import com.solvd.delivery.bin.Customer;
import com.solvd.delivery.dao.impl.CustomerDAO;

import java.util.List;

public class CustomerService {

    ICustomerDAO customerDao = new CustomerDAO();

    public Customer getCustomerByID(int customerID) {
        return customerDao.getByID(customerID);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAll();
    }

    public void addCustomer(Customer customer) {
        customerDao.insert(customer);
    }

    public void deleteCustomerByID(int id) {
        customerDao.deleteByID(id);
    }

}
