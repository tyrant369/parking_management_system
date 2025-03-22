package com.parkinglot.model;

import java.util.Date;

public class ParkingTicket {

    private String ticketId;
    private Vehicle vehicle;
    private Date entryTime;
    private Date exitTime;

    public ParkingTicket(String ticketId, Date entryTime, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
}
