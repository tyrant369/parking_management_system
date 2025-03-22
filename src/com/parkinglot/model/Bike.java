package com.parkinglot.model;

public class Bike extends Vehicle{

    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }

    @Override
    public int getRequiredSpots() {
        return 1;
    }
}
