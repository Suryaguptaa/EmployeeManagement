package com.emapp.EmployeeManagement.employee;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeRole role;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private List<Employee> subordinates;

    protected Employee(){
    }

    public Employee(String fullname, String email, EmployeeRole role){
        this.fullname = fullname;
        this.email=email;
        this.role = role;
    }

    public Long getId(){
        return id;
    }

    public String getFullname(){
        return fullname;
    }

    public String getEmail(){
        return email;
    }

    public EmployeeRole getRole(){
        return role;
    }

    public Employee getManager(){
        return manager;
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
