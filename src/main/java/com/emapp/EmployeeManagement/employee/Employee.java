package com.emapp.EmployeeManagement.employee;

import jakarta.persistence.*;


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
}
