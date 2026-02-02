package com.emapp.EmployeeManagement.worklog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreatedWorkLogRequest {

    @NotNull
    private Long employeeId;

    @NotBlank
    private String description;

    @NotNull
    private WorkType workType;

    @NotNull
    private WorkStatus status;

    @NotNull
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getDescription() {
        return description;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public WorkStatus getStatus() {
        return status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
