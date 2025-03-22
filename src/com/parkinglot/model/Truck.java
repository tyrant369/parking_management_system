package com.parkinglot.model;

public class Truck extends Vehicle{

    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }

    @Override
    public int getRequiredSpots() {
        return 4;
    }
}
