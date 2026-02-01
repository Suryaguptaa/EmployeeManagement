package com.emapp.EmployeeManagement.employee;

import jakarta.validation.constraints.NotNull;

public class AssignManagerRequest {

    @NotNull
    private Long employeeId;

    @NotNull
    private Long managerId;

    public Long getEmployeeId(){
        return employeeId;
    }

    public Long getManagerId(){
        return managerId;
    }
}
