package com.mrodrigochaves.employee.service;

import java.util.List;
import java.util.Optional;

import com.mrodrigochaves.employee.dto.EmployeeDTO;

import jakarta.validation.Valid;
public interface EmployeeService {
    

    List<EmployeeDTO> getAll();

    List<EmployeeDTO> getByLastName(String name);

    List<EmployeeDTO> getByDepartment(String name);

    List<EmployeeDTO> getByTitle(String name);

    Optional<EmployeeDTO> create(EmployeeDTO request);

    Optional<EmployeeDTO> getById(Long id);

    Optional<EmployeeDTO> update(Long id, @Valid EmployeeDTO request);

    Optional<EmployeeDTO> deleteById(Long id);


}
