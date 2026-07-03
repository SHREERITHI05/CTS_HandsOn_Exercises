package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDaoImpl() {
        LOGGER.debug("Inside EmployeeDaoImpl Constructor. Loading employee.xml.");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList", List.class);
        LOGGER.debug("Loaded {} employees from XML.", EMPLOYEE_LIST.size());
    }

    @Override
    public List<Employee> getAllEmployees() {
        LOGGER.debug("Start getAllEmployees() DAO method.");
        LOGGER.debug("End getAllEmployees() DAO method. Count: {}", EMPLOYEE_LIST.size());
        return EMPLOYEE_LIST;
    }
}