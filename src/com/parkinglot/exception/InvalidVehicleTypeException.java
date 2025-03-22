package com.parkinglot.exception;

public class InvalidVehicleTypeException extends RuntimeException{
    public InvalidVehicleTypeException(String message) {
        super(message);
    }
}
