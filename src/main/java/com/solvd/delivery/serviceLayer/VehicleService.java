package com.solvd.delivery.serviceLayer;

import com.solvd.delivery.dao.IVehicleDAO;
import com.solvd.delivery.bin.Vehicle;
import com.solvd.delivery.dao.impl.VehicleDAO;

public class VehicleService {

    IVehicleDAO vehicleDAO = new VehicleDAO();

    public Vehicle getVehicleByID(int id) {
        return vehicleDAO.getByID(id);
    }

}
