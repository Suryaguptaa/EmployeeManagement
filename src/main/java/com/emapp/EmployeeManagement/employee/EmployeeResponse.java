package com.emapp.EmployeeManagement.employee;

public class EmployeeResponse {

    private final String id;
    private final String fullname;
    private final String email;
    private final EmployeeRole role;

    public EmployeeResponse(String id, String fullname, String email, EmployeeRole role){
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.role = role;
    }

    public String getId(){
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeRole getRole() {
        return role;
    }

}
