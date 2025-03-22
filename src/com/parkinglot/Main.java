package com.parkinglot;

import com.parkinglot.controller.ParkingLotController;
import com.parkinglot.factory.VehicleFactory;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Vehicle;
import com.parkinglot.model.VehicleType;
import com.parkinglot.repository.ParkingLotRepository;
import com.parkinglot.service.ParkingLotService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize repository
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        // Add some parking spots
        parkingLotRepository.addParkingSpot(new ParkingSpot("spot1", VehicleType.CAR));
        parkingLotRepository.addParkingSpot(new ParkingSpot("spot2", VehicleType.BIKE));
        parkingLotRepository.addParkingSpot(new ParkingSpot("spot3", VehicleType.TRUCK));

        // Initialize service and controller
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        ParkingLotController parkingLotController = new ParkingLotController(parkingLotService);

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Parking Lot Management System =====");
            System.out.println("1. Park a Vehicle");
            System.out.println("2. Unpark a Vehicle");
            System.out.println("3. View Available Spots");
            System.out.println("4. Load Data from File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Park a Vehicle
                    System.out.print("Enter vehicle type (CAR, BIKE, TRUCK): ");
                    String vehicleTypeInput = scanner.nextLine().toUpperCase();
                    VehicleType vehicleType = VehicleType.valueOf(vehicleTypeInput);

                    System.out.print("Enter vehicle license plate: ");
                    String licensePlate = scanner.nextLine();

                    Vehicle vehicle = VehicleFactory.createVehicle(vehicleType, licensePlate);

                    System.out.println(vehicle);
                    parkingLotController.parkVehicle(vehicle);
                    break;

                case 2:
                    // Unpark a Vehicle
                    System.out.print("Enter parking spot ID: ");
                    String spotId = scanner.nextLine();
                    parkingLotController.unParkVehicle(spotId);
                    break;

                case 3:
                    // View Available Spots
                    System.out.println("\nAvailable Parking Spots:");
                    for (ParkingSpot spot : parkingLotRepository.getAvailableParkingSpots(VehicleType.CAR).values()) {
                        System.out.println("Spot ID: " + spot.getSpotId() + ", Type: " + spot.getSpotType());
                    }
                    break;

                case 4:
                    // Load Data from File
                    parkingLotRepository.loadFromFile();
                    System.out.println("Data loaded from file successfully.");
                    break;

                case 5:
                    // Exit
                    exit = true;
                    System.out.println("Exiting the Parking Lot Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}