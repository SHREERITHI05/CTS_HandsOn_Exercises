package com.cognizant.spring_learn.model;

import java.util.List;

public class Employee {

    private int id;
    private String name;
    private String email;
    private String department;
    private List<String> skills;

    public Employee() {
    }

    public Employee(int id, String name, String email, String department, List<String> skills) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', email='" + email
                + "', department='" + department + "', skills=" + skills + "}";
    }
}