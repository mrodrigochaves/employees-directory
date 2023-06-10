package com.mrodrigochaves.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrodrigochaves.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    List<Employee> findByLastName(String lastName);

    List<Employee> findByDepartment(String department);

    List<Employee> findByTitle(String title);
    
}
