package com.emapp.EmployeeManagement.ai;

import com.emapp.EmployeeManagement.worklog.ManagerWeeklySummaryResponse;

import java.time.LocalDate;
import java.util.List;

public class WeeklyTeamFacts {

    private String managerName;
    private final LocalDate weekStart;
    private final List<ManagerWeeklySummaryResponse> teamSummaries;

    public WeeklyTeamFacts(
            String managerName,
            LocalDate weekStart,
            List<ManagerWeeklySummaryResponse> teamSummaries
    ) {
            this.managerName = managerName;
            this.weekStart = weekStart;
            this.teamSummaries = teamSummaries;
    }

    public String getManagerName() {
        return managerName;
    }

    public LocalDate getWeekStart() {
        return weekStart;
    }

    public List<ManagerWeeklySummaryResponse> getTeamSummaries() {
        return teamSummaries;
    }
}
