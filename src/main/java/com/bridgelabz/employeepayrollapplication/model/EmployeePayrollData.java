package com.bridgelabz.employeepayrollapplication.model;

import com.bridgelabz.employeepayrollapplication.DTO.EmployeePayrollDTO;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public @Data class EmployeePayrollData {
    private int employeeID;
    private String name;
    private Long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    private List<String> department;

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeID = empId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note=employeePayrollDTO.note;
        this.profilePic=employeePayrollDTO.profilePic;
        this.department=employeePayrollDTO.department;

    }
}
