package com.example.restcrudmysql.rest;

import com.example.restcrudmysql.entity.Employee;
import com.example.restcrudmysql.exception.EmployeeNotFoundException;
import com.example.restcrudmysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    @GetMapping("/employees/sorted")
    public List<Employee> getEmployeesSorted() {
        return employeeService.findAllByOrderByLastNameAsc();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // in case an id is passed in JSON ... set it to 0
        // this is to force a save of a new item ... instead of an update
        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Integer id ,@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.findById(id);

        if (dbEmployee == null) {
            throw new EmployeeNotFoundException("An employee with this id is not found!");
        }

        // Set the id from path variable to ensure we're updating the correct employee
        employee.setId(id);

        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new EmployeeNotFoundException("An employee with this id is not found!");
        }

        employeeService.deleteById(id);

        return "Deleted employee with the id: " + id;
    }

}
