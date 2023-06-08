package com.solvd.delivery.dao.impl;

import com.solvd.delivery.dao.IVehicleDAO;
import com.solvd.delivery.bin.Vehicle;
import com.solvd.delivery.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO implements IVehicleDAO {

    public static final Logger LOGGER = LogManager.getLogger(Vehicle.class);
    private static final ConnectionPool cp = ConnectionPool.getInstance();

    private static final String GET_BY_ID = "SELECT * FROM vehicles WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM vehicles";
    private static final String INSERT = "INSERT INTO Vehicles(make, model, capacity, in_service) values (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM vehicles WHERE id = ?";
    private static final String UPDATE = "UPDATE vehicles SET make= ?, model= ?, capacity= ?, in_service= ? WHERE id= ?";

    @Override
    public Vehicle getByID(int id) {

        Connection connection = cp.requestConnection();
        Vehicle vehicle = new Vehicle();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                vehicle.setId(results.getInt("id"));
                vehicle.setMake(results.getString("make"));
                vehicle.setModel(results.getString("model"));
                vehicle.setCapacity(results.getInt("capacity"));
                vehicle.setInService(results.getBoolean("in_Service"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            closeResources(connection, ps);
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getAll() {

        Connection connection = cp.requestConnection();
        List<Vehicle> vehicleList = new ArrayList<>();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(GET_ALL);
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(results.getInt("id"));
                vehicle.setMake(results.getString("make"));
                vehicle.setModel(results.getString("model"));
                vehicle.setCapacity(results.getInt("capacity"));
                vehicle.setInService(results.getBoolean("in_Service"));
                vehicleList.add(vehicle);
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            closeResources(connection, ps);
        }
        return vehicleList;
    }

    @Override
    public void insert(Vehicle vehicle) {

        Connection connection = cp.requestConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(INSERT);
            ps.setString(1, vehicle.getMake());
            ps.setString(2, vehicle.getModel());
            ps.setInt(3, vehicle.getCapacity());
            ps.setBoolean(4, vehicle.isInService());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            closeResources(connection, ps);
        }
    }


    @Override
    public void update(Vehicle vehicle, int id) {

        Connection connection = cp.requestConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(UPDATE);
            ps.setString(1, vehicle.getMake());
            ps.setString(2, vehicle.getModel());
            ps.setInt(3, vehicle.getCapacity());
            ps.setBoolean(4, vehicle.isInService());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            closeResources(connection, ps);
        }

    }

    @Override
    public void deleteByID(int id) {

        Connection connection = cp.requestConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            closeResources(connection, ps);
        }
    }

    private void closeResources(Connection connection, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cp.releaseConnection(connection);
    }
}
