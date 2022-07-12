package com.bridgelabz.employeepayrollapplication.DTO;

public class EmployeePayrollDTO {
    public String name;
    public long salary;

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}