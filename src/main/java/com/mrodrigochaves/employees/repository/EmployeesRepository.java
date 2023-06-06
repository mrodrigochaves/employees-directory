package com.mrodrigochaves.employees.repository;

import com.mrodrigochaves.employees.model.Employees;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    Optional<Employees> findByName(String name);
    
}
