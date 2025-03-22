package com.parkinglot.model;

public class Car extends Vehicle{

    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }

    @Override
    public int getRequiredSpots() {
        return 2;
    }
}
