package com.example.restcrudmysql.dao;

import com.example.restcrudmysql.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

}
