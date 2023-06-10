package com.mrodrigochaves.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mrodrigochaves.employee.dto.EmployeeDTO;

import jakarta.validation.Valid;


@Repository 
public interface EmployeeService {
    
    Optional<EmployeeDTO> create(EmployeeDTO request);

    List<EmployeeDTO> getAll();

    Optional<EmployeeDTO> getById(Long id);

    Optional<EmployeeDTO> update(Long id, @Valid EmployeeDTO request);

    List<EmployeeDTO> getByLastName(String name);

    List<EmployeeDTO> getByDepartament(String name);

    List<EmployeeDTO> getByTitle(String name);

    boolean delete(Long id);


}
