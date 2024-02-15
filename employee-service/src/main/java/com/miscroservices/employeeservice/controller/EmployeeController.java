package com.miscroservices.employeeservice.controller;

import com.miscroservices.employeeservice.model.Employee;
import com.miscroservices.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {} " + employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") Long id){
        LOGGER.info("get employee By id : {} " + id);
        return employeeRepository.findById(id);
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("getting all the Employees");
        return employeeRepository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getByDepartment(@PathVariable("departmentId") Long id){
        LOGGER.info("get By Department Id : {} "+ id);
        return employeeRepository.findByDepartment(id);
    }
}
