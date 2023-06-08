package com.solvd.delivery.service.impl;

import com.solvd.delivery.dao.IDriverDAO;
import com.solvd.delivery.bin.Driver;
import com.solvd.delivery.dao.impl.DriverDAO;

import java.util.List;

public class DriverService {

    IDriverDAO driverDao = new DriverDAO();

    public Driver getDriverByID(int id) {
        return driverDao.getByID(id);
    }

    public List<Driver> getAllDrivers() {
        return  driverDao.getAll();
    }

    public void addDriver(Driver driver) {
        driverDao.insert(driver);
    }

    public void deleteDriverByID(int id) {
        driverDao.deleteByID(id);
    }

}
