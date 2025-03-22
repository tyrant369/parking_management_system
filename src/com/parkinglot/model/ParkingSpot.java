package com.parkinglot.model;

import java.io.Serializable;

public class ParkingSpot implements Serializable {

    private String spotId;
    private VehicleType spotType;
    private boolean isAvailable;

    public ParkingSpot(String spotId, VehicleType spotType, boolean isAvailable) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public ParkingSpot(String spotId, VehicleType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public String getSpotId() {
        return spotId;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
