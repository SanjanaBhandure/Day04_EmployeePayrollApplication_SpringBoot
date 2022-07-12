/*
Spring Employee Payroll App Development.
* Section 2: UC-1 Introducing DTO and Model to Employee Payroll App - Note that we have kept the DTO and Model fairly
simplistic with only Name and Salary.
- This is because we are still in the setup of the Layers and once set we would make Employee Payroll as full-fledged
Object for Front End to make REST Call.
- Currently we will do CURL Call to ensure the REST Calls are working.

* @author: Sanjana Bhandure.
* @version: 1.2
* @date: 12-07-2022
*/

package com.bridgelabz.employeepayrollapplication.controllers;

import com.bridgelabz.employeepayrollapplication.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeePayrollService")
public class EmployeePayrollController {

    @RequestMapping(value = {"","/","get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Sanjana",30000));
        ResponseDTO respDTO = new ResponseDTO("Get call Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Sanjana",30000));
        ResponseDTO respDTO = new ResponseDTO("Get call for ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Update Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " +empId);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
}
