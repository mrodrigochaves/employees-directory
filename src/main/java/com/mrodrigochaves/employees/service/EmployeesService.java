package com.mrodrigochaves.employees.service;

import java.util.List;
import java.util.Optional;

import com.mrodrigochaves.employees.dto.EmployeesDTO;

import jakarta.validation.Valid;

public interface EmployeesService {
    
    Optional<EmployeesDTO> create(EmployeesDTO request);

    List<EmployeesDTO> getAll();

    Optional<EmployeesDTO> getById(Long id);

   
    Optional<EmployeesDTO> update(Long id, @Valid EmployeesDTO request);

    void delete(Long id);


    boolean inactive(Long id);

    Optional<EmployeesDTO> getByName(String name);

}
