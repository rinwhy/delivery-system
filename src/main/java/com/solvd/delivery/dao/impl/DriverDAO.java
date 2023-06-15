package com.solvd.delivery.dao.impl;

import com.solvd.delivery.dao.IDriverDAO;
import com.solvd.delivery.bin.Driver;
import com.solvd.delivery.dao.IVehicleDAO;
import com.solvd.delivery.utils.ConnectionPool;
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
    private static final ConnectionPool cp = ConnectionPool.getInstance();

    private static final String GET_BY_ID = "SELECT * FROM Drivers WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM Drivers";
    private static final String INSERT = "INSERT into Drivers(name, email, vehicle_ID) VALUES (?,?,?)";
    private static final String DELETE = "DELETE FROM Drivers WHERE id = ?";
    private static final String UPDATE = "UPDATE Drivers SET name= ?, email= ?, vehicle_ID=?  WHERE id= ?";

    @Override
    public Driver getByID(int id) {

        Connection connection = cp.requestConnection();
        Driver driver = new Driver();
        IVehicleDAO vehicleDAO = new VehicleDAO();

        try (PreparedStatement ps = connection.prepareStatement(GET_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet results = ps.executeQuery()) {
                while (results.next()) {
                    driver.setId(results.getInt("id"));
                    driver.setName(results.getString("name"));
                    driver.setEmail(results.getString("email"));
                    driver.setVehicle(vehicleDAO.getByID(results.getInt("vehicle_id")));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
        return driver;
    }

    @Override
    public List<Driver> getAll() {

        Connection connection = cp.requestConnection();
        VehicleDAO vehicleDAO = new VehicleDAO();
        List<Driver> driverList = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL)) {
            try (ResultSet results = ps.executeQuery()) {
                while (results.next()) {
                    Driver driver = new Driver();
                    driver.setId(results.getInt("id"));
                    driver.setName(results.getString("name"));
                    driver.setEmail(results.getString("email"));
                    driver.setVehicle(vehicleDAO.getByID(results.getInt("vehicle_id")));
                    driverList.add(driver);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
        return driverList;
    }

    @Override
    public void insert(Driver driver) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setString(1, driver.getName());
            ps.setString(2, driver.getEmail());
            ps.setInt(3, driver.getVehicle().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int id) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

    @Override
    public void update(Driver driver, int id) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, driver.getName());
            ps.setString(2, driver.getEmail());
            ps.setInt(3, driver.getVehicle().getId());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

}

