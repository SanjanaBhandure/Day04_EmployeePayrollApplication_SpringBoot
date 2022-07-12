package com.bridgelabz.employeepayrollapplication.services;

import com.bridgelabz.employeepayrollapplication.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollServices implements IEmployeePayrollService{

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream()
                .filter(empData -> empData.getEmployeeID() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrollList.size() + 1, employeePayrollDTO);
        employeePayrollList.add(empData);
        return empData;
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        employeePayrollList.set(empId - 1, empData);
        return empData;
    }

    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId - 1);
    }
}
