package com.example.restcrudmysql.dao;

import com.example.restcrudmysql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
