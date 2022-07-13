package com.bridgelabz.employeepayrollapplication.services;

import com.bridgelabz.employeepayrollapplication.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapplication.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollServices implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;
    //private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException(("Employee with employeeOd " + empId + "does not exists...")));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrollDTO);
        log.debug("Emp Data: "+empData.toString());
        return employeePayrollRepository.save(empData);
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(empData);
    }



    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);

    }
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
}
