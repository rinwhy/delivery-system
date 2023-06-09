package com.solvd.delivery.bin;

public class Vehicle extends BaseTable{

    private String make;
    private String model;
    private int capacity;
    private boolean inService;

    public int getId() {
        return super.id;
    }

    public void setId(int id) {
        super.id = id;
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
                "id=" + super.id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", inService=" + inService +
                '}';
    }
}
