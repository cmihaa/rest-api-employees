package com.example.restapiemployee.employee;

import com.example.restapiemployee.employee.dao.EmployeeDao;
import com.example.restapiemployee.employee.dao.EmployeeEntity;
import com.example.restapiemployee.employee.request.EmployeeReq;
import com.example.restapiemployee.employee.response.EmployeeResp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestControllerEmployee {

    @Autowired
    EmployeeService employeeService;



    @PostMapping("/employees")
    public ResponseEntity<EmployeeResp> createEmployee(@RequestBody EmployeeReq emp) {
        return ResponseEntity.ok(employeeService.createEmployee(emp));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeEntity>> getEmployee (){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResp> getEmployeeById (@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping ("/employees/{id}")
    public ResponseEntity<EmployeeResp> updateEmployee (@PathVariable Long id,@RequestBody EmployeeReq employeeUp){
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeUp));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
    }

//    @DeleteMapping("/employees/{id}")
//    public void deleteEmployeeById(@PathVariable Long id){
//        employeeService.deleteEmployeeById(id);
//    }


}
