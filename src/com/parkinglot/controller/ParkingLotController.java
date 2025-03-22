package com.parkinglot.controller;

import com.parkinglot.exception.ParkingSpotNotFoundException;
import com.parkinglot.exception.ParkinglotFullException;
import com.parkinglot.model.Vehicle;
import com.parkinglot.service.ParkingLotService;

public class ParkingLotController {

    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public void parkVehicle (Vehicle vehicle) {

        try {

            System.out.println("vehicle in controller : " + vehicle.getLicensePlate());
            parkingLotService.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully: " + vehicle.getLicensePlate());
        } catch (ParkinglotFullException e) {
            System.out.println("Error: " + e.getMessage()); // Return HTTP 400 (Bad Request)
        } catch (ParkingSpotNotFoundException e) {
            System.out.println("Error: " + e.getMessage()); // Return HTTP 404 (Not Found)
        } catch (Exception e) {
            System.out.println("Internal server error: " + e.getMessage()); // Return HTTP 500 (Internal Server Error)
        }
    }

    public void unParkVehicle (String spotId) {

        try {
            parkingLotService.unParkVehicle(spotId);
            System.out.println("Vehicle unparked successfully from spot: " + spotId);
        } catch (ParkingSpotNotFoundException e) {
            System.out.println("Error: " + e.getMessage()); // Return HTTP 404 (Not Found)
        } catch (Exception e) {
            System.out.println("Internal server error: " + e.getMessage()); // Return HTTP 500 (Internal Server Error)
        }
    }
}
