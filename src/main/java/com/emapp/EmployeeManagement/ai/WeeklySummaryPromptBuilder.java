package com.emapp.EmployeeManagement.ai;

import com.emapp.EmployeeManagement.worklog.ManagerWeeklySummaryResponse;
import org.springframework.stereotype.Component;

@Component
public class WeeklySummaryPromptBuilder {

    public String buildPrompt(WeeklyTeamFacts facts)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Generate a weekly team summary. \n");
        sb.append("Manager: ").append(facts.getManagerName()).append("\n");
        sb.append("Week Starting: ").append(facts.getWeekStart()).append("\n\n");

        for (ManagerWeeklySummaryResponse summary : facts.getTeamSummaries())
        {
            sb.append("- ")
                    .append(summary.getEmployeeName())
                    .append(": ")
                    .append(summary.getCompletedCount())
                    .append(" completed, ")
                    .append(summary.getInProgressCount())
                    .append(" in progress\n");
        }

        sb.append("\nDo not add assumption. Do not add numbers not present");

        return sb.toString();
    }
}
