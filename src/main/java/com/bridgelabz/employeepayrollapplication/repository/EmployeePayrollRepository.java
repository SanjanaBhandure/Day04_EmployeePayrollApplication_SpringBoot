package com.bridgelabz.employeepayrollapplication.repository;

import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
}
