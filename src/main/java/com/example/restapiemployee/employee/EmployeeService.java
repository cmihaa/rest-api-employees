package com.example.restapiemployee.employee;

import com.example.restapiemployee.employee.dao.EmployeeDao;
import com.example.restapiemployee.employee.dao.EmployeeEntity;
import com.example.restapiemployee.employee.request.EmployeeReq;
import com.example.restapiemployee.employee.response.EmployeeResp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public EmployeeResp createEmployee(EmployeeReq emp) {

        EmployeeEntity employeeEntity = new EmployeeEntity(
                emp.getName(),
                emp.getCNP(),
                emp.getDateOfBirth()
        );
        employeeDao.save(employeeEntity);
        return new EmployeeResp(employeeEntity);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeDao.findAll();
    }

    public EmployeeResp getEmployeeById(Long id) {
        Optional<EmployeeEntity> employee = this.employeeDao.findById(id);
        // declaram un EmployeeResp null
        if (employee.isPresent()) {
            return new EmployeeResp(employee.get());
        }
        return null;
    }

    public EmployeeResp updateEmployee(Long id, EmployeeReq employeeReq) {
        EmployeeEntity employeeEntity = this.employeeDao.findById(id).get();
        employeeEntity.setName(employeeReq.getName());
        employeeEntity.setCNP(employeeReq.getCNP());
        employeeEntity.setDateOfBirth(employeeReq.getDateOfBirth());
        this.employeeDao.save(employeeEntity);
        return new EmployeeResp(employeeEntity);
    }


    public boolean deleteEmployeeById(Long id) {
        if(this.getEmployeeById(id)!= null){
            this.employeeDao.deleteById(id);
            return true;
        }
        else return false;
    }
}