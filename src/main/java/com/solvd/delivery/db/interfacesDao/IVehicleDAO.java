package com.solvd.delivery.db.interfacesDao;

import com.solvd.delivery.db.model.Vehicle;

public interface IVehicleDAO {

    Vehicle getVehicleByID(int id);
}
