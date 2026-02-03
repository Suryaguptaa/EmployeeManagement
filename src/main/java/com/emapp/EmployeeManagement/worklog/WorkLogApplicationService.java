package com.emapp.EmployeeManagement.worklog;

import com.emapp.EmployeeManagement.common.exception.InvalidOperationException;
import com.emapp.EmployeeManagement.common.exception.ResourceNotFoundException;
import com.emapp.EmployeeManagement.employee.Employee;
import com.emapp.EmployeeManagement.employee.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class WorkLogApplicationService {

    private final WorkLogRepository workLogRepository;
    private final EmployeeRepository employeeRepository;

    public WorkLogApplicationService(
            WorkLogRepository workLogRepository,
            EmployeeRepository employeeRepository
    ){
        this.workLogRepository = workLogRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void logWork(CreatedWorkLogRequest request){

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        if(request.getStatus() == WorkStatus.COMPLETED && request.getEndTime()==null){
            throw new InvalidOperationException(
                    "End time is required when work status is COMPLETED"
            );
        }

        if(request.getStatus() == WorkStatus.IN_PROGRESS && request.getEndTime()!=null){
            throw new InvalidOperationException(
                    "End time must be null when work status is IN_PROGRESS"
            );
        }

        WorkLog workLog = new WorkLog(
                employee,
                request.getDescription(),
                request.getWorkType(),
                request.getStatus(),
                request.getStartTime(),
                request.getEndTime()
        );

        workLogRepository.save(workLog);
    }

    public List<WorkLogResponse> getWorkLogsForEmployee(Long employeeId){

        return workLogRepository
                .findByEmployeeIdOrderByStartTimeDesc(employeeId)
                .stream()
                .map(log -> new WorkLogResponse(
                        log.getId(),
                        log.getDescription(),
                        log.getWorkType(),
                        log.getStatus(),
                        log.getStartTime(),
                        log.getEndTime()
                ))
                .toList();
    }

    public List<WorkLogResponse> getDailySummary(
            Long employeeId,
            LocalDate date
    ){
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23,59,59);

        return workLogRepository
                .findByEmployeeIdAndStartTimeBetween(employeeId,startOfDay,endOfDay)
                .stream()
                .map(log -> new WorkLogResponse(
                        log.getId(),
                        log.getDescription(),
                        log.getWorkType(),
                        log.getStatus(),
                        log.getStartTime(),
                        log.getEndTime()
                ))
                .toList();
    }

    public List<WorkLogResponse> getWeeklySummary(
            Long employeeId,
            LocalDate weekStartDate
    ){
        LocalDateTime start = weekStartDate.atStartOfDay();
        LocalDateTime end = weekStartDate.plusDays(6).atTime(23,59,59);

        return workLogRepository
                .findByEmployeeIdAndStartTimeBetween(employeeId,start,end)
                .stream()
                .map(log -> new WorkLogResponse(
                        log.getId(),
                        log.getDescription(),
                        log.getWorkType(),
                        log.getStatus(),
                        log.getStartTime(),
                        log.getEndTime()
                ))
                .toList();
    }

    public List<ManagerWeeklySummuryResponse> getManagerWeeklyResponse(
            Long managerId,
            LocalDate weekStartDate
    )
    {
        Employee manager = employeeRepository.findById(managerId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Manager Not Found"));

        List<Employee> subordinates = manager.getSubordinates();

        if(subordinates.isEmpty()){
            return List.of();
        }

        List<Long> employeeIds = subordinates.stream()
                .map(Employee::getId)
                .toList();

        LocalDateTime start = weekStartDate.atStartOfDay();
        LocalDateTime end = weekStartDate.plusDays(6).atTime(23,59,59);

        List<WorkLog> logs = workLogRepository.findByEmployeeIdInAndStartTimeBetween(
                employeeIds,start,end
        );

        return subordinates.stream()
                .map(emp -> {
                    List<WorkLog> empLogs = logs.stream()
                            .filter(log ->  log.getEmployee().getId().equals(emp.getId()))
                            .toList();

                    long completed = empLogs.stream()
                            .filter(l -> l.getStatus() == WorkStatus.COMPLETED)
                            .count();

                    long inProgress = empLogs.stream()
                            .filter(l -> l.getStatus() == WorkStatus.IN_PROGRESS)
                            .count();

                    return new ManagerWeeklySummuryResponse(
                            emp.getId(),
                            emp.getFullname(),
                            empLogs.size(),
                            completed,
                            inProgress
                    );
                })
                .toList();
    }

}
