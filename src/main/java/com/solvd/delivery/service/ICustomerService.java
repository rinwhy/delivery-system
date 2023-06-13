package com.solvd.delivery.service;

import com.solvd.delivery.bin.Customer;

public interface ICustomerService {

    void saveCustomerToDB(Customer customer);

    void showAllCustomers();

    void removeCustomerFromDB(Customer customer);
    void removeCustomerFromDB(int id);

}
