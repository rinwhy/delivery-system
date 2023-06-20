package com.solvd.delivery.service.impl;

import com.solvd.delivery.dao.ICustomerDAO;
import com.solvd.delivery.bin.Customer;
import com.solvd.delivery.dao.impl.CustomerDAO;
import com.solvd.delivery.service.ICustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class CustomerService implements ICustomerService {

    private static final Logger LOGGER = LogManager.getLogger(CustomerService.class);
    private static final ICustomerDAO dao = new CustomerDAO();

    @Override
    public Customer getCustomerByID(int id) {
        if (id > 0) {
            return dao.getByID(id);
        } else LOGGER.warn("Invalid ID provided! ");
        return null;
    }

    @Override
    public void addCustomerToDB(Customer customer) {
        if (customer.getName() != null &&
            customer.getAddress() != null &&
            customer.getEmail() != null) {
                dao.insert(customer);
                LOGGER.info("Successfully added to database\n");
        } else
            LOGGER.warn("Error inserting customer to database");
    }

    @Override
    public List<Customer> getAllCustomers() {
        return dao.getAll();
    }

    @Override
    public void removeCustomerFromDB(Customer customer) {
        if (customer.getId() > 0) {
            dao.deleteByID(customer.getId());
        } else LOGGER.warn("Invalid Customer ID provided! ");
    }

    @Override
    public void removeCustomerFromDB(int id) {
        if (id > 0) {
            dao.deleteByID(id);
        } else LOGGER.warn("Invalid ID provided! ");
    }

}
