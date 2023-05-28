package com.example.restapiemployee.employee.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @Column(name ="employeeId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Long CNP;

    @Column
    private LocalDate dateOfBirth;

    public EmployeeEntity(){

    }

    public EmployeeEntity(String name, Long CNP, LocalDate dateOfBirth) {
        this.name = name;
        this.CNP = CNP;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCNP() {
        return CNP;
    }

    public void setCNP(Long CNP) {
        this.CNP = CNP;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
