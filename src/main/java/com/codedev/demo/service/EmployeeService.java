package com.codedev.demo.service;


import com.codedev.demo.model.entity.Employee;
import com.codedev.demo.model.EmployeePage;
import com.codedev.demo.model.EmployeeSearchCriteria;
import com.codedev.demo.repository.EmployeeCriteriaRepository;
import com.codedev.demo.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final EmployeeCriteriaRepository employeeCriteriaRepo;

    public EmployeeService(EmployeeRepository employeeRepo, EmployeeCriteriaRepository employeeCriteriaRepo) {
        this.employeeRepo = employeeRepo;
        this.employeeCriteriaRepo = employeeCriteriaRepo;
    }

    public Page<Employee> getEmployees(EmployeePage employeePage, EmployeeSearchCriteria searchCriteria){
        return employeeCriteriaRepo.findAllWithFilters(employeePage, searchCriteria);
    }

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
}
