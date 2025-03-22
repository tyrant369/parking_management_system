package com.parkinglot.repository;


import com.parkinglot.exception.DataAccessException;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Vehicle;
import com.parkinglot.model.VehicleType;
import com.parkinglot.utils.FileUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class ParkingLotRepository implements Serializable {

    private Map<String, ParkingSpot> parkingSpot = new HashMap<>();
    private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
    private Map<String, Vehicle> parkedVehicle = new HashMap<>();

    public ParkingLotRepository () {
        loadFromFile();
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpotRepository.addParkingSpot(spot);
        saveToFile();
    }

    public ParkingSpot getParkingSpot(String spotId) {
        return parkingSpotRepository.getParkingSpot(spotId);
    }

    public void parkVehicle(String spotId, Vehicle vehicle) {
        try {
            parkedVehicle.put(spotId, vehicle);
            parkingSpotRepository.updateParkingSpotAvailability(spotId, false);
            saveToFile();
        } catch (Exception e) {
            throw new DataAccessException("Error parking vehicle: " + e.getMessage(), e);
        }
    }

    public Vehicle unParkVehicle(String spotId) {
        try {
            Vehicle vehicle = parkedVehicle.remove(spotId);
            if (vehicle != null) {
                parkingSpotRepository.updateParkingSpotAvailability(spotId, true);
            }
            saveToFile();
            return vehicle;
        } catch (Exception e) {
            throw new DataAccessException("Error unParking vehicle: " + e.getMessage(), e);
        }
    }

    public boolean isSpotAvailable(String spotId) {
        ParkingSpot spot = parkingSpotRepository.getParkingSpot(spotId);
        return spot != null && spot.isAvailable();
    }

    public Map<String, ParkingSpot> getParkingSpots() {
        return parkingSpotRepository.getAllParkingSpots();
    }

    public Map<String, ParkingSpot> getAvailableParkingSpots(VehicleType type) {
        return parkingSpotRepository.getAvailableParkingSpots(type);
    }

    public Map<String, Vehicle> getParkedVehicles() {
        return parkedVehicle;
    }

    // Public method to load data from file
    public void loadFromFile() {
        System.out.println("Loading data from file...");
        ParkingLotRepository data = (ParkingLotRepository) FileUtils.loadFromFile();
        if (data != null) {
            this.parkingSpotRepository = data.parkingSpotRepository;
            this.parkedVehicle = data.parkedVehicle;
            System.out.println("Loaded Parking Spots: " + parkingSpotRepository.getAllParkingSpots());
            System.out.println("Loaded Parked Vehicles: " + parkedVehicle);
        }

        else {
            System.out.println("No data found in file.");
        }
    }

    private void saveToFile() {
        System.out.println("Saving data to file...");
        System.out.println("Parking Spots: " + parkingSpotRepository.getAllParkingSpots());
        System.out.println("Parked Vehicles: " + parkedVehicle);
        FileUtils.saveToFile(this);
    }

    public Map<String, ParkingSpot> getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(Map<String, ParkingSpot> parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
