package com.emapp.EmployeeManagement;

import com.emapp.EmployeeManagement.employee.EmployeeRequest;
import com.emapp.EmployeeManagement.employee.EmployeeResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeApplicationService employeeApplicationService;

    public EmployeeController(EmployeeApplicationService employeeApplicationService){
        this.employeeApplicationService = employeeApplicationService;
    }

    @PostMapping
    public EmployeeResponse createEmployee(@Valid @RequestBody EmployeeRequest request){
            return employeeApplicationService.createEmployee(request);
    }
}
