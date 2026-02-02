package com.emapp.EmployeeManagement.team;


import com.emapp.EmployeeManagement.department.Department;
import com.emapp.EmployeeManagement.employee.Employee;
import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Department department;

    @ManyToOne
    private Employee manager;

    protected Team(){}

    public Team(String name, Department department, Employee manager){
        this.name=name;
        this.department = department;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee getManager() {
        return manager;
    }
}
