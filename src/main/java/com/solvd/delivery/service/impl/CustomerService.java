package com.solvd.delivery.service.impl;

import com.solvd.delivery.dao.ICustomerDAO;
import com.solvd.delivery.bin.Customer;
import com.solvd.delivery.dao.impl.CustomerDAO;
import com.solvd.delivery.service.ICustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CustomerService implements ICustomerService {

    private static final Logger LOGGER = LogManager.getLogger(CustomerService.class);


    @Override
    public void saveCustomerToDB(Customer customer) {
        if (customer.getName() != null &&
            customer.getAddress() != null &&
            customer.getEmail() != null) {
            ICustomerDAO dao = new CustomerDAO();
            dao.insert(customer);
        }
    }

    @Override
    public void showAllCustomers() {
        ICustomerDAO dao = new CustomerDAO();
        dao.getAll().forEach(customer -> LOGGER.info(customer.toString()));
    }

    @Override
    public void removeCustomerFromDB(Customer customer) {
        ICustomerDAO dao = new CustomerDAO();
        dao.deleteByID(customer.getId());
    }

    @Override
    public void removeCustomerFromDB(int id) {
        ICustomerDAO dao = new CustomerDAO();
        dao.deleteByID(id);
    }


}
