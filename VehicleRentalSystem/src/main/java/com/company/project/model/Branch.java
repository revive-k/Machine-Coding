package com.company.project.model;

import java.util.HashMap;
import java.util.Map;

public class Branch {
    String branchName;
    Map<VehicleType, Integer> priceVehicleTypeMap;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.priceVehicleTypeMap = new HashMap<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Map<VehicleType, Integer> getPriceVehicleTypeMap() {
        return priceVehicleTypeMap;
    }

    public void setPriceVehicleTypeMap(Map<VehicleType, Integer> priceVehicleTypeMap) {
        this.priceVehicleTypeMap = priceVehicleTypeMap;
    }
}
