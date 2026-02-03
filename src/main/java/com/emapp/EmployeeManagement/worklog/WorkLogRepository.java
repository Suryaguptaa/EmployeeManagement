package com.emapp.EmployeeManagement.worklog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkLogRepository extends JpaRepository<WorkLog, Long> {
    List<WorkLog> findByEmployeeId(Long employeeId);
    List<WorkLog> findByEmployeeIdOrderByStartTimeDesc(Long employeeId);
    List<WorkLog> findByEmployeeIdAndStartTimeBetween(
            Long employeeId,
            LocalDateTime start,
            LocalDateTime end
    );

    List<WorkLog> findByEmployeeIdInAndStartTimeBetween(
            List<Long> employeeId,
            LocalDateTime start,
            LocalDateTime end
    );
}
