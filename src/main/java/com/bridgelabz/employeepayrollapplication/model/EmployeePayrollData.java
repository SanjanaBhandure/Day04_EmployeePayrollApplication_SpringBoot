package com.bridgelabz.employeepayrollapplication.model;

import com.bridgelabz.employeepayrollapplication.DTO.EmployeePayrollDTO;

public class EmployeePayrollData {
    private  long salary;
    private  String name;
    private int employeeID;
    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeID = empId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeID = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
}
