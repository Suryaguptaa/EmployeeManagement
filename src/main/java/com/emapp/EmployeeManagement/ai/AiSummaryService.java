package com.emapp.EmployeeManagement.ai;

import org.springframework.stereotype.Service;

@Service
public class AiSummaryService {

    public String generateSummary(String prompt) {

        return """
               Weekly Summary (AI-Generated)
               --------------------------------
               This week shows consistent work patterns across the team.
               The manager maintained balanced workload distribution,
               with steady progress and no major inactivity risks detected.
               """;
    }
}
