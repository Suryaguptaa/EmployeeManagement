package com.emapp.EmployeeManagement.common.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email){
        super("Employee with email " + email + " already exists");
    }
}
