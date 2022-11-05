package com.company.project.util;

import com.company.project.model.RideTime;
import com.company.project.model.Vehicle;
import com.company.project.model.VehicleType;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class VehicleUtil {

    public static Vehicle getVehicleById(final String vehicleId, final List<Vehicle> vehicleList){
        if(Objects.isNull(vehicleList)) return null;
        for (Vehicle vehicle : vehicleList) {
            if(vehicleId.equals(vehicle.getVehicleId())){
                return vehicle;
            }
        }
        return null;
    }

    public static Vehicle getVehicleByIdAndVehicleType(final String vehicleId, final VehicleType vehicleType, final List<Vehicle> vehicleList){
        if(Objects.isNull(vehicleList)) return null;
        for (Vehicle vehicle : vehicleList) {
            if(vehicleId.equals(vehicle.getVehicleId()) && vehicleType.equals(vehicle.getVehicleType())){
                return vehicle;
            }
        }
        return null;
    }

    public static boolean isVehicleAvailableInGivenTime(final Timestamp startTime, final Timestamp endTime, final Vehicle vehicle){
        List<RideTime> bookedTimes = vehicle.getBookedSlots();
        for (RideTime bookedTime : bookedTimes) {
            if(startTime.equals(bookedTime.getStartTime()) || endTime.equals(bookedTime.getEndTime())){
                return false;
            }
            if(startTime.after(bookedTime.getStartTime()) && startTime.before(bookedTime.getEndTime())){
                return false;
            }
            if(bookedTime.getStartTime().after(startTime) && bookedTime.getEndTime().before(endTime)){
                return false;
            }
            if(endTime.after(bookedTime.getStartTime()) && endTime.before(bookedTime.getEndTime())){
                return false;
            }
        }
        return true;
    }
}
