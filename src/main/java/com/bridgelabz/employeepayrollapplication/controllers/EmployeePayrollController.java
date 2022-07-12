/*
Spring Employee Payroll App Development.
* Section 4: UC-3 Ability to throw User Friendly Errors in case Employee Id is not found in Employee Payroll App.
- Define a Custom Exception for Employee Not Found and through when Employee Id is passed as parameter.
- Handle such Exceptions in @ExceptionHandler method for EmployeeNotException class.
*
* @author: Sanjana Bhandure.
* @version: 1.11
* @date: 12-07-2022
*/

package com.bridgelabz.employeepayrollapplication.controllers;

import com.bridgelabz.employeepayrollapplication.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapplication.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeePayrollService")
public class EmployeePayrollController {

   @Autowired
   private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"","/","get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get call Successful", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get call for ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Create Employee PayrollData:", empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable ("empId") int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Update Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted successfully", "Deleted id: " + empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
