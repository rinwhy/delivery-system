package com.solvd.delivery.db.interfacesDao;

import com.solvd.delivery.db.model.Customer;

import java.sql.SQLException;

public interface ICustomerDAO {

        Customer getUserByID(int id) throws SQLException;

}