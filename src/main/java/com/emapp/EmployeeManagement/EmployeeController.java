package com.emapp.EmployeeManagement;

import com.emapp.EmployeeManagement.employee.AssignManagerRequest;
import com.emapp.EmployeeManagement.employee.EmployeeRequest;
import com.emapp.EmployeeManagement.employee.EmployeeResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/assign-manager")
    public ResponseEntity<Void> assignManager(
            @Valid @RequestBody AssignManagerRequest request
            ){
        employeeApplicationService.assignManager(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{managerId}/subordinates")
    public List<EmployeeResponse> getSubordinates(@PathVariable Long managerId){
        return employeeApplicationService.getSubordinates(managerId);
    }
}
