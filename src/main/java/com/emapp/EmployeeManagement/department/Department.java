package com.emapp.EmployeeManagement.department;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    protected Department(){}

    public Department(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    private String getName(){
        return name;
    }
}
