package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.DepartmentDao;
import com.cognizant.spring_learn.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional
    public List<Department> getAllDepartments() {
        LOGGER.debug("Start getAllDepartments() service method.");
        List<Department> departments = departmentDao.getAllDepartments();
        LOGGER.debug("End getAllDepartments() service method.");
        return departments;
    }
}