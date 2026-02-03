package com.emapp.EmployeeManagement.worklog;

public class ManagerWeeklySummuryResponse {

    private final Long employeeId;
    private final String employeeName;
    private final long totalLogs;
    private final long completedCount;
    private final long inProgressCount;

    public


    ManagerWeeklySummuryResponse(
            Long employeeId,
            String employeeName,
            long totalLogs,
            long completedCount,
            long inProgressCount
    )
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.totalLogs=totalLogs;
        this.completedCount=completedCount;
        this.inProgressCount=inProgressCount;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public long getTotalLogs() {
        return totalLogs;
    }

    public long getCompletedCount() {
        return completedCount;
    }

    public long getInProgressCount() {
        return inProgressCount;
    }
}
