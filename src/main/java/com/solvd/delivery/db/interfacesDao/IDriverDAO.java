package com.solvd.delivery.db.interfacesDao;

import com.solvd.delivery.db.model.Driver;

import java.util.List;

public interface IDriverDAO {

    Driver getDriverByID(int id);
    List<Driver> getAllDrivers();
    void addDriver(Driver driver);
    void deleteDriverByID(int id);

}
