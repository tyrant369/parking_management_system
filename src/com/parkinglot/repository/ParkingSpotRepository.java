package com.parkinglot.repository;

import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.VehicleType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository implements Serializable {
    private Map<String, ParkingSpot> parkingSpots = new HashMap<>();

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.put(spot.getSpotId(), spot);
    }

    public ParkingSpot getParkingSpot(String spotId) {
        return parkingSpots.get(spotId);
    }

    public void updateParkingSpotAvailability(String spotId, boolean isAvailable) {
        ParkingSpot spot = parkingSpots.get(spotId);
        if (spot != null) {
            spot.setAvailable(isAvailable);
        }
    }

    public Map<String, ParkingSpot> getAllParkingSpots() {
        return parkingSpots;
    }

    public Map<String, ParkingSpot> getAvailableParkingSpots(VehicleType type) {
        Map<String, ParkingSpot> availableSpots = new HashMap<>();
        for (Map.Entry<String, ParkingSpot> entry : parkingSpots.entrySet()) {
            ParkingSpot spot = entry.getValue();
            if (spot.getSpotType() == type && spot.isAvailable()) {
                availableSpots.put(entry.getKey(), spot);
            }
        }
        return availableSpots;
    }
}