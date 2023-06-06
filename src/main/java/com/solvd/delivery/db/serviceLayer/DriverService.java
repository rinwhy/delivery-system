package com.solvd.delivery.db.serviceLayer;

import com.solvd.delivery.db.interfacesDao.IDriverDAO;
import com.solvd.delivery.db.model.Driver;
import com.solvd.delivery.db.mysql.dao.DriverDAO;

import java.util.List;

public class DriverService {

    IDriverDAO driverDao = new DriverDAO();

    public Driver getDriverByID(int id) {
        return driverDao.getDriverByID(id);
    }

    public List<Driver> getAllDrivers() {
        return  driverDao.getAllDrivers();
    }

    public void addDriver(Driver driver) {
        driverDao.addDriver(driver);
    }

    public void deleteDriverByID(int id) {
        driverDao.deleteDriverByID(id);
    }

}
