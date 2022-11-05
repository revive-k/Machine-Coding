package com.company.project.util;

import com.company.project.model.Branch;

import java.util.List;
import java.util.Objects;

public class BranchUtil {

    public static Branch getBranchFromBranchName(final String branchName, final List<Branch> branchList){
        if(Objects.isNull(branchList)) return null;
        for (Branch branch : branchList) {
            if(branchName.equals(branch.getBranchName())){
                return branch;
            }
        }
        return null;
    }

}
