package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
}