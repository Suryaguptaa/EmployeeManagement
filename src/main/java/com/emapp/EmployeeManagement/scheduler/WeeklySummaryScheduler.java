package com.emapp.EmployeeManagement.scheduler;

import com.emapp.EmployeeManagement.ai.AiSummaryService;
import com.emapp.EmployeeManagement.ai.WeeklySummaryPromptBuilder;
import com.emapp.EmployeeManagement.ai.WeeklyTeamFacts;
import com.emapp.EmployeeManagement.employee.Employee;
import com.emapp.EmployeeManagement.employee.EmployeeRepository;
import com.emapp.EmployeeManagement.employee.EmployeeRole;
import com.emapp.EmployeeManagement.worklog.ManagerWeeklySummaryResponse;
import com.emapp.EmployeeManagement.worklog.WorkLogApplicationService;
import com.emapp.EmployeeManagement.worklog.WorkLogRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
    public class WeeklySummaryScheduler {
    private final EmployeeRepository employeeRepository;
    private final WorkLogApplicationService workLogService;
    private final WeeklySummaryPromptBuilder promptBuilder;
    private final AiSummaryService aiSummaryService;

    public WeeklySummaryScheduler(
            EmployeeRepository employeeRepository,
            WorkLogApplicationService workLogService,
            WeeklySummaryPromptBuilder promptBuilder,
            AiSummaryService aiSummaryService
    ) {
        this.employeeRepository = employeeRepository;
        this.workLogService = workLogService;
        this.promptBuilder = promptBuilder;
        this.aiSummaryService = aiSummaryService;
    }

    @Scheduled(cron = "0 0 9 ? * MON")
    public void generateWeeklySummaries() {

        LocalDate weekStart = LocalDate.now().minusDays(7);

        List<Employee> managers =
                employeeRepository.findByRole(EmployeeRole.MANAGER);

        for (Employee manager : managers) {

            List<ManagerWeeklySummaryResponse> data =
                    workLogService.getManagerWeeklySummary(
                            manager.getId(),
                            weekStart
                    );

            if (data.isEmpty()) {
                continue;
            }

            WeeklyTeamFacts facts = new WeeklyTeamFacts(
                    manager.getFullname(),
                    weekStart,
                    data
            );

            String prompt = promptBuilder.buildPrompt(facts);
            String summary = aiSummaryService.generateSummary(prompt);

            System.out.println(
                    "Weekly summary for " + manager.getFullname()
            );
            System.out.println(summary);
        }
    }
    }
