package com.solvd.delivery.db.mysql.dao;

import com.solvd.delivery.db.interfacesDao.IDriverDAO;
import com.solvd.delivery.db.model.Driver;
import com.solvd.delivery.db.mysql.connection.ConnectionPool;
import com.solvd.delivery.db.serviceLayer.VehicleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO implements IDriverDAO {

    public static final Logger LOGGER = LogManager.getLogger(Driver.class);

    @Override
    public Driver getDriverByID(int id) {
        Connection connection = ConnectionPool.getConnection();
        Driver driver = new Driver();

        VehicleService vs = new VehicleService();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Drivers WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                driver.setId(results.getInt("id"));
                driver.setName(results.getString("name"));
                driver.setEmail(results.getString("email"));
                driver.setVehicle(vs.getVehicleByID(results.getInt("vehicle_id")));
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
        return driver;
    }

    @Override
    public List<Driver> getAllDrivers() {
        Connection connection = ConnectionPool.getConnection();

        VehicleService vs = new VehicleService();
        List<Driver> driverList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Drivers");
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                Driver driver = new Driver();
                driver.setId(results.getInt("id"));
                driver.setName(results.getString("name"));
                driver.setEmail(results.getString("email"));
                driver.setVehicle(vs.getVehicleByID(results.getInt("vehicle_id")));
                driverList.add(driver);
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }

        return driverList;
    }

    @Override
    public void addDriver(Driver driver) {

        Connection connection = ConnectionPool.getConnection();
        String statement = "insert into Drivers(name, email, vehicle_ID) VALUES (?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getEmail());
            preparedStatement.setInt(3, driver.getVehicleID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
    }

    @Override
    public void deleteDriverByID(int id) {
        Connection connection = ConnectionPool.getConnection();
        String statement = "DELETE FROM Drivers WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
    }

}
