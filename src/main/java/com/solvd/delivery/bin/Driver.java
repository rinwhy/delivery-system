package com.solvd.delivery.bin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "name", "email", "vehicle"})
public class Driver {

    private int id;
    private String name;
    private String email;
    private Vehicle vehicle;

    public Driver() {
    }

    public Driver(String name, String email, Vehicle vehicle) {
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;
    }

    public Driver(int id, String name, String email, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Driver {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", vehicleID=" + vehicle.getId() +
                '}';
    }
}
