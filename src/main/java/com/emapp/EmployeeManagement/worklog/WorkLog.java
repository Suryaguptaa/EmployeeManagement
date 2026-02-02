package com.emapp.EmployeeManagement.worklog;

import com.emapp.EmployeeManagement.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "work_logs")
public class WorkLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkType workType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkStatus status;

    @Column(nullable = false)
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private WorkLog(){}

        public WorkLog (
                Employee employee,
                String description,
                WorkType workType,
                WorkStatus status,
                LocalDateTime startTime,
                LocalDateTime endTime
        ){
        this.employee = employee;
        this.description = description;
        this.workType=workType;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
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
