package com.example.restapiemployee.employee.request;

import lombok.*;

import java.time.LocalDate;

@Setter @Getter @AllArgsConstructor @ToString
public class EmployeeReq {

    private String name;
    private Long CNP;
    private LocalDate dateOfBirth;
}
