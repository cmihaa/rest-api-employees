package com.example.restapiemployee.employee.response;

import com.example.restapiemployee.employee.dao.EmployeeEntity;
import lombok.*;

import java.time.LocalDate;

@Setter @Getter @AllArgsConstructor
public class EmployeeResp {

    private String name;
    private Long CNP;
    private LocalDate dateOfBirth;
    private Long id;

    public EmployeeResp(EmployeeEntity employeeEntity) {
        this.name = employeeEntity.getName();
        this.CNP = employeeEntity.getCNP();
        this.dateOfBirth = employeeEntity.getDateOfBirth();
        this.id = employeeEntity.getId();
    }


}
