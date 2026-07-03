package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDaoImpl.class);

    private static ArrayList<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDaoImpl() {
        LOGGER.debug("Inside DepartmentDaoImpl Constructor. Loading employee.xml.");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList", List.class);
        LOGGER.debug("Loaded {} departments from XML.", DEPARTMENT_LIST.size());
    }

    @Override
    public List<Department> getAllDepartments() {
        LOGGER.debug("Start getAllDepartments() DAO method.");
        LOGGER.debug("End getAllDepartments() DAO method. Count: {}", DEPARTMENT_LIST.size());
        return DEPARTMENT_LIST;
    }
}