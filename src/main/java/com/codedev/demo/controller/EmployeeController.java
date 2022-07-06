package com.codedev.demo.controller;

import com.codedev.demo.model.entity.Employee;
import com.codedev.demo.model.EmployeePage;
import com.codedev.demo.model.EmployeeSearchCriteria;
import com.codedev.demo.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(EmployeePage employeePage, EmployeeSearchCriteria searchCriteria){
        return new ResponseEntity<>(employeeService.getEmployees(employeePage, searchCriteria), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }
}
