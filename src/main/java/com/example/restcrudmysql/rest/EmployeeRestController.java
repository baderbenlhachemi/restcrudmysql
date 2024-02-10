package com.example.restcrudmysql.rest;

import com.example.restcrudmysql.dao.EmployeeDao;
import com.example.restcrudmysql.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeRestController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }
}
