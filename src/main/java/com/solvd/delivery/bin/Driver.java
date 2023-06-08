package com.solvd.delivery.bin;

public class Driver extends BaseTable{

    private String name;
    private String email;
    private Vehicle vehicle;

    public int getId() {
        return super.id;
    }

    public void setId(int id) {
        super.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVehicleID() {
        return vehicle.getId();
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Driver {" +
                "id=" + super.id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", vehicleID=" + vehicle.getId() +
                '}';
    }
}
