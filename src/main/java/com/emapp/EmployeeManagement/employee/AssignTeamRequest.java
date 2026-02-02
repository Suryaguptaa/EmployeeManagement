package com.emapp.EmployeeManagement.employee;

import jakarta.validation.constraints.NotNull;

public class AssignTeamRequest {

    @NotNull
    private Long employeeId;

    @NotNull
    private Long teamId;

    public Long getEmployeeId(){
        return employeeId;
    }

    public Long getTeamId(){
        return teamId;
    }

}
