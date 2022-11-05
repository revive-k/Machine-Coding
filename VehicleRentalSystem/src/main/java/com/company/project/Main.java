package com.company.project;

import com.company.project.model.Vehicle;
import com.company.project.model.VehicleType;
import com.company.project.service.VehicleRentalService;
import com.company.project.service.VehicleRentalServiceImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void printInventory(List<Vehicle> inventory){
        System.out.println("========Printing inventory==========");
        for (Vehicle vehicle : inventory) {
            System.out.print(vehicle.getBranchName() + " " + vehicle.getVehicleType() + " " + vehicle.getVehicleId() + " "
                    + (vehicle.isAvailable() ? "Available" : "Booked"));
            System.out.println();
        }
    }

    public static void printBookVehicle(Vehicle vehicle){
        if(Objects.isNull(vehicle)){
            System.out.println("REQUESTED VEHICLE TYPE NOT AVAILABLE");
            return;
        }
        System.out.println("======Printing booking=========");
        System.out.println(vehicle.getVehicleId() + " from " + vehicle.getBranchName() + " booked.");
    }

    public static void main(String[] args) {
        VehicleRentalService vehicleRentalService = new VehicleRentalServiceImpl();
        vehicleRentalService.addBranch("Vasanth Vihar");
        vehicleRentalService.addBranch("Cyber City");
        vehicleRentalService.allocatePrice("Vasanth Vihar", VehicleType.Sedan, 100);
        vehicleRentalService.allocatePrice("Vasanth Vihar", VehicleType.Hatchback, 80);
        vehicleRentalService.allocatePrice("Cyber City", VehicleType.Sedan, 200);
        vehicleRentalService.allocatePrice("Cyber City", VehicleType.Hatchback, 50);
        vehicleRentalService.addVehicle("DL 01 MR 9310", VehicleType.Sedan, "Vasanth Vihar");
        vehicleRentalService.addVehicle("DL 01 MR 9311", VehicleType.Sedan, "Cyber City");
        vehicleRentalService.addVehicle("DL 01 MR 9312", VehicleType.Hatchback, "Cyber City");
        Vehicle bookedVehicle = vehicleRentalService.bookVehicle(VehicleType.Sedan, Timestamp.valueOf("2020-02-29 10:00:00"), Timestamp.valueOf("2020-02-29 13:00:00"));
        printBookVehicle(bookedVehicle);
        bookedVehicle = vehicleRentalService.bookVehicle(VehicleType.Sedan, Timestamp.valueOf("2020-02-29 14:00:00"), Timestamp.valueOf("2020-02-29 15:00:00"));
        printBookVehicle(bookedVehicle);
        bookedVehicle = vehicleRentalService.bookVehicle(VehicleType.Sedan, Timestamp.valueOf("2020-02-29 14:00:00"), Timestamp.valueOf("2020-02-29 15:00:00"));
        printBookVehicle(bookedVehicle);
        bookedVehicle = vehicleRentalService.bookVehicle(VehicleType.Sedan, Timestamp.valueOf("2020-02-29 14:00:00"), Timestamp.valueOf("2020-02-29 15:00:00"));
        printBookVehicle(bookedVehicle);
        List<Vehicle> inventory = vehicleRentalService.viewVehicleInventory(Timestamp.valueOf("2020-02-29 14:00:00"), Timestamp.valueOf("2020-02-29 15:00:00"));
        printInventory(inventory);
        inventory = vehicleRentalService.viewVehicleInventory(Timestamp.valueOf("2020-02-29 16:00:00"), Timestamp.valueOf("2020-02-29 17:00:00"));
        printInventory(inventory);
        bookedVehicle = vehicleRentalService.bookVehicle(VehicleType.Hatchback, Timestamp.valueOf("2020-02-29 14:00:00"), Timestamp.valueOf("2020-02-29 15:00:00"));
        printBookVehicle(bookedVehicle);
        bookedVehicle = vehicleRentalService.bookVehicle(VehicleType.Hatchback, Timestamp.valueOf("2020-02-29 14:00:00"), Timestamp.valueOf("2020-02-29 15:00:00"));
        printBookVehicle(bookedVehicle);
        inventory = vehicleRentalService.viewVehicleInventory(Timestamp.valueOf("2020-02-29 14:00:00"), Timestamp.valueOf("2020-02-29 16:00:00"));
        printInventory(inventory);
        inventory = vehicleRentalService.viewVehicleInventory(Timestamp.valueOf("2020-02-29 15:00:00"), Timestamp.valueOf("2020-02-29 16:00:00"));
        printInventory(inventory);
    }
}
