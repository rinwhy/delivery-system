package com.solvd.delivery.db.serviceLayer;

import com.solvd.delivery.db.interfacesDao.IVehicleDAO;
import com.solvd.delivery.db.model.Vehicle;
import com.solvd.delivery.db.mysql.dao.VehicleDAO;

public class VehicleService {

    IVehicleDAO vehicleDAO = new VehicleDAO();

    public Vehicle getVehicleByID(int id) {
        return vehicleDAO.getVehicleByID(id);
    }

}
