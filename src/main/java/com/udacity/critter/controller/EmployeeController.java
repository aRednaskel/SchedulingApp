package com.udacity.critter.controller;

import com.udacity.critter.dto.EmployeeDTO;
import com.udacity.critter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/employee")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    public EmployeeDTO getEmployee(long id) {
        return null;
    }
}
