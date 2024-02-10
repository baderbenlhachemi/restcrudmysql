package com.example.restcrudmysql.dao;

import com.example.restcrudmysql.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // query
        TypedQuery<Employee> typedQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = typedQuery.getResultList();

        return employees;
    }
}
