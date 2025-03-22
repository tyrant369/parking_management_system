package com.parkinglot.factory;

import com.parkinglot.model.*;

public class VehicleFactory {

    public static Vehicle createVehicle (VehicleType type, String licensePlate) {

        return switch (type) {
            case CAR -> new Car(licensePlate);
            case BIKE -> new Bike(licensePlate);
            case TRUCK -> new Truck(licensePlate);
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        };
    }
}
