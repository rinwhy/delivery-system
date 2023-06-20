package com.solvd.delivery.service;

import com.solvd.delivery.bin.Customer;

import java.util.List;

public interface ICustomerService {

    Customer getCustomerByID(int id);
    void addCustomerToDB(Customer customer);
    List<Customer> getAllCustomers();
    void removeCustomerFromDB(Customer customer);
    void removeCustomerFromDB(int id);

}
