package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> getAllDepartments();
}