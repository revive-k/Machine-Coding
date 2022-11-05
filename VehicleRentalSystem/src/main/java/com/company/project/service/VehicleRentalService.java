package com.company.project.service;

import com.company.project.model.Branch;
import com.company.project.model.Vehicle;
import com.company.project.model.VehicleType;

import java.sql.Timestamp;
import java.util.List;

public interface VehicleRentalService {
    Branch addBranch(final String branchName);

    boolean allocatePrice(final String branchName, final VehicleType vehicleType, final Integer price);

    Vehicle addVehicle(final String vehicleId, final VehicleType vehicleType, final String branchName);

    Vehicle bookVehicle(final VehicleType vehicleType, final Timestamp startTime, final Timestamp endTime);

    List<Vehicle> viewVehicleInventory(final Timestamp startTime, final Timestamp endTime);
}
