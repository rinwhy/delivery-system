package com.solvd.delivery.db.interfaces;

import com.solvd.delivery.db.model.Customer;

import java.sql.SQLException;

public interface ICustomerDAO {

        Customer getUserByID(int id) throws SQLException;

}
