package com.mrodrigochaves.employees.repository;

import com.mrodrigochaves.employees.model.Employees;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    List<Employees> findByLastName(String name);    

    List<Employees> findByDepartament(String name);

    List<Employees> findByTitle(String name);

   


    
}
