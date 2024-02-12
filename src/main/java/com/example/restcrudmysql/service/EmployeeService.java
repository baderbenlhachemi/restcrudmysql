package com.example.restcrudmysql.service;

import com.example.restcrudmysql.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    List<Employee> findAllByOrderByLastNameAsc();
    Employee findById(Integer id);
    Employee save(Employee employee);
    void deleteById(Integer id);
}
