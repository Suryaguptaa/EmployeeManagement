package com.emapp.EmployeeManagement.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeRequest {

    @NotBlank
    private String fullname;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private EmployeeRole role;

    public String getFullname(){
        return fullname;
    }

    public String getEmail(){
        return email;
    }

    public EmployeeRole getRole(){
        return role;
    }
}
