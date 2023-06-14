package com.solvd.delivery.bin;

public class Vehicle {

    private int id;
    private String make;
    private String model;
    private int capacity;
    private boolean inService;

    public Vehicle() {
    }

    public Vehicle(String make, String model, int capacity, boolean inService) {
        this.make = make;
        this.model = model;
        this.capacity = capacity;
        this.inService = inService;
    }

    public Vehicle(int id, String make, String model, int capacity, boolean inService) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.capacity = capacity;
        this.inService = inService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isInService() {
        return inService;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }

    @Override
    public String toString() {
        return "Vehicle {" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", inService=" + inService +
                '}';
    }
}
