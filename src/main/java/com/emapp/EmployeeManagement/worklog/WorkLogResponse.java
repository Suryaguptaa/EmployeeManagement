package com.emapp.EmployeeManagement.worklog;

import java.time.LocalDateTime;

public class WorkLogResponse {

    private final Long id;
    private final String description;
    private final WorkType workType;
    private final WorkStatus status;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public WorkLogResponse(
            Long id,
            String description,
            WorkType workType,
            WorkStatus status,
            LocalDateTime startTime,
            LocalDateTime endTime
    ) {
        this.id = id;
        this.description = description;
        this.workType = workType;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
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
