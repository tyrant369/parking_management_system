package com.parkinglot.model;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    private String licensePlate;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public abstract int getRequiredSpots();
}
