package com.mrodrigochaves.employee.repository;

import com.mrodrigochaves.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
