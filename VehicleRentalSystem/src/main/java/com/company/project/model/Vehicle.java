package com.company.project.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    String vehicleId;
    VehicleType vehicleType;
    String branchName;
    List<RideTime> bookedSlots;
    boolean isAvailable;

    public Vehicle(String vehicleId, VehicleType vehicleType, String branchName) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.branchName = branchName;
        this.bookedSlots = new ArrayList<>();
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<RideTime> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(List<RideTime> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }
}
