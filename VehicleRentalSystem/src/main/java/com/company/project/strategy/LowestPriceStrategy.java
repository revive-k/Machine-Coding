package com.company.project.strategy;

import com.company.project.model.Branch;
import com.company.project.model.Vehicle;
import com.company.project.model.VehicleType;
import com.company.project.util.BranchUtil;
import com.company.project.util.VehicleUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LowestPriceStrategy {

    public Vehicle getAvailableVehicleWithLowestPrice(final VehicleType vehicleType, final Timestamp startTime, final Timestamp endTime, final List<Vehicle> vehicles, final List<Branch> branches){
        Vehicle vehicle = null;
        Integer priceOfVehicle = Integer.MAX_VALUE;
        List<Vehicle> availableVehicles = getAvailableVehicles(vehicleType, startTime, endTime, vehicles);
        for (Vehicle availableVehicle : availableVehicles) {
            String branchName = availableVehicle.getBranchName();
            Branch branch = BranchUtil.getBranchFromBranchName(branchName, branches);
            Map<VehicleType, Integer> priceMap = branch.getPriceVehicleTypeMap();
            if(Objects.nonNull(priceMap)){
                Integer price = priceMap.get(availableVehicle.getVehicleType());
                if(priceOfVehicle > price){
                    vehicle = availableVehicle;
                    priceOfVehicle = price;
                }
            }
        }
        return vehicle;
    }

    private List<Vehicle> getAvailableVehicles(final VehicleType vehicleType, final Timestamp startTime, final Timestamp endTime, final List<Vehicle> vehicles){
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if(vehicleType.equals(vehicle.getVehicleType()) && VehicleUtil.isVehicleAvailableInGivenTime(startTime, endTime, vehicle)){
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }
}
