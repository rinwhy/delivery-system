package com.solvd.delivery.db.mysql.dao;

import com.solvd.delivery.db.interfacesDao.IVehicleDAO;
import com.solvd.delivery.db.model.Vehicle;
import com.solvd.delivery.db.mysql.connection.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleDAO implements IVehicleDAO {

    public static final Logger LOGGER = LogManager.getLogger(Vehicle.class);

    @Override
    public Vehicle getVehicleByID(int id) {
        Connection connection = ConnectionPool.getConnection();
        Vehicle vehicle = new Vehicle();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                vehicle.setId(results.getInt("id"));
                vehicle.setMake(results.getString("make"));
                vehicle.setModel(results.getString("model"));
                vehicle.setCapacity(results.getInt("capacity"));
                vehicle.setInService(results.getBoolean("in_Service"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
        return vehicle;
    }
}
