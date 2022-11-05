package com.company.project.service;

import com.company.project.exception.ServiceException;
import com.company.project.model.Branch;
import com.company.project.model.RideTime;
import com.company.project.model.Vehicle;
import com.company.project.model.VehicleType;
import com.company.project.strategy.LowestPriceStrategy;
import com.company.project.util.BranchUtil;
import com.company.project.util.VehicleUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VehicleRentalServiceImpl implements VehicleRentalService{
    private List<Branch> allBranches;
    private List<Vehicle> allVehicles;
    private LowestPriceStrategy lowestPriceStrategy = new LowestPriceStrategy();

    public VehicleRentalServiceImpl() {
        this.allBranches = new ArrayList<>();
        this.allVehicles = new ArrayList<>();
    }

    @Override
    public Branch addBranch(String branchName) {
        Branch newBranch = new Branch(branchName);
        Branch existingBranch = BranchUtil.getBranchFromBranchName(branchName, allBranches);
        if(Objects.nonNull(existingBranch)){
            throw new ServiceException("Provided branch already exists");
        }
        allBranches.add(newBranch);
        return newBranch;
    }

    @Override
    public boolean allocatePrice(String branchName, VehicleType vehicleType, Integer price) {
        Branch branch = BranchUtil.getBranchFromBranchName(branchName, allBranches);
        if(Objects.isNull(branch)){
            throw new ServiceException("Given branch doesn't exist");
        }
        Map<VehicleType, Integer> priceToVehicleTypeMap = branch.getPriceVehicleTypeMap();
        priceToVehicleTypeMap.put(vehicleType, price);
        branch.setPriceVehicleTypeMap(priceToVehicleTypeMap);
        return true;
    }

    @Override
    public Vehicle addVehicle(String vehicleId, VehicleType vehicleType, String branchName) {
        Vehicle newVehicle = new Vehicle(vehicleId, vehicleType, branchName);
        Vehicle existingVehicle = VehicleUtil.getVehicleById(vehicleId, allVehicles);
        if(Objects.nonNull(existingVehicle)){
            throw new ServiceException("Provided vehicle already exists");
        }
        allVehicles.add(newVehicle);
        return newVehicle;
    }

    @Override
    public Vehicle bookVehicle(VehicleType vehicleType, Timestamp startTime, Timestamp endTime) {
        Vehicle vehicle = lowestPriceStrategy.getAvailableVehicleWithLowestPrice(vehicleType, startTime, endTime, allVehicles, allBranches);
        if(Objects.isNull(vehicle)){
            return null;
        }
        for (Vehicle tempVehicle : allVehicles) {
            if(vehicle.getVehicleId().equals(tempVehicle.getVehicleId())){
                List<RideTime> bookedTimes = tempVehicle.getBookedSlots();
                bookedTimes.add(new RideTime(startTime, endTime));
                tempVehicle.setBookedSlots(bookedTimes);
            }
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> viewVehicleInventory(Timestamp startTime, Timestamp endTime) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : allVehicles) {
            Vehicle myVehicle = new Vehicle(vehicle.getVehicleId(), vehicle.getVehicleType(),
                    vehicle.getBranchName());
            myVehicle.setBookedSlots(vehicle.getBookedSlots());
            myVehicle.setAvailable(VehicleUtil.isVehicleAvailableInGivenTime(startTime, endTime, vehicle));
            vehicles.add(myVehicle);
        }
        return vehicles;
    }
}
