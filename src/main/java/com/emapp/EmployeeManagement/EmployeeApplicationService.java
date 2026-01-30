package com.emapp.EmployeeManagement;


import com.emapp.EmployeeManagement.common.exception.EmailAlreadyExistsException;
import com.emapp.EmployeeManagement.employee.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class EmployeeApplicationService {

    private final EmployeeRepository employeeRepository;

    public EmployeeApplicationService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public EmployeeResponse createEmployee(EmployeeRequest request) {

        boolean emailExists = employeeRepository.findByEmail(request.getEmail()).isPresent();

        if(emailExists){
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        Employee employee = new Employee(
                request.getFullname(),
                request.getEmail(),
                request.getRole()
        );


        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeResponse(
                savedEmployee.getId().toString(),
                savedEmployee.getFullname(),
                savedEmployee.getEmail(),
                savedEmployee.getRole()
        );

    }
}
