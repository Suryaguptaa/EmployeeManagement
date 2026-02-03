package com.emapp.EmployeeManagement.worklog;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/work-logs")
public class WorkLogController {

    private final WorkLogApplicationService workLogApplicationService;

    public WorkLogController(WorkLogApplicationService workLogApplicationService){
        this.workLogApplicationService = workLogApplicationService;
    }

    @PostMapping
    public ResponseEntity<Void> logWork(
            @Valid @RequestBody CreatedWorkLogRequest request
    ){
        workLogApplicationService .logWork(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/{employeeId}")
    public List<WorkLogResponse> getWorkLogForEmployee(
            @PathVariable Long employeeId
    ){
        return workLogApplicationService.getWorkLogsForEmployee(employeeId);
    }

    @GetMapping("/employee/{employeeId}/daily")
    public List<WorkLogResponse> getDailySummary(
            @PathVariable Long employeeId,
            @RequestParam LocalDate date
            )
    {
       return workLogApplicationService.getDailySummary(employeeId,date);
    }

    @GetMapping("/employee/{employeeId}/weekly")
    public List<WorkLogResponse> getWeeklySummary
            (
            @PathVariable Long employeeId,
            @RequestParam LocalDate startDate
    ){
        return workLogApplicationService.getWeeklySummary(employeeId, startDate);
    }

    public List<ManagerWeeklySummuryResponse> getManagerWeeklySummary(
            @PathVariable Long managerId,
            @RequestParam LocalDate startDate
    )
    {
        return workLogApplicationService.getManagerWeeklyResponse(managerId,startDate);
    }
}
