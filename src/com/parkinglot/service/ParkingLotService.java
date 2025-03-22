package com.parkinglot.service;

import com.parkinglot.exception.InvalidVehicleTypeException;
import com.parkinglot.exception.ParkingSpotNotFoundException;
import com.parkinglot.exception.ParkinglotFullException;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Vehicle;
import com.parkinglot.model.VehicleType;
import com.parkinglot.repository.ParkingLotRepository;
import com.parkinglot.utils.FileUtils;

import java.util.Map;

public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;

        if (this.parkingLotRepository == null) {
            this.parkingLotRepository = new ParkingLotRepository(); // Initialize if no data is found
        }
    }

    public void parkVehicle(Vehicle vehicle) throws InvalidVehicleTypeException, ParkinglotFullException, ParkingSpotNotFoundException {

        // Find an available spot for the vehicle
        ParkingSpot availableSpot = findAvailableSpot(vehicle.getType());
        if (availableSpot == null) {
            throw new ParkinglotFullException("No available spots for " + vehicle.getType());
        }

        // Park the vehicle
        parkingLotRepository.parkVehicle(availableSpot.getSpotId(), vehicle);

        // Save data to file after parking
        FileUtils.saveToFile(parkingLotRepository);
    }

    public void unParkVehicle(String spotId) throws ParkingSpotNotFoundException {

        // UnPark the vehicle
        Vehicle vehicle = parkingLotRepository.unParkVehicle(spotId);
        if (vehicle == null) {
            throw new ParkingSpotNotFoundException("Spot not found or already empty: " + spotId);
        }

        // Save data to file after unparking
        FileUtils.saveToFile(parkingLotRepository);
    }

    private ParkingSpot findAvailableSpot(VehicleType type) {

        Map<String, ParkingSpot> availableSpots = parkingLotRepository.getAvailableParkingSpots(type);

        if (!availableSpots.isEmpty()) {
            return availableSpots.values().iterator().next();
        }

        return null;
    }
}
