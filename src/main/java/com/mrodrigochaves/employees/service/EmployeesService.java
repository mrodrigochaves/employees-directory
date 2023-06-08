package com.mrodrigochaves.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mrodrigochaves.employees.dto.EmployeesDTO;

import jakarta.validation.Valid;


@Repository 
public interface EmployeesService {
    
    Optional<EmployeesDTO> create(EmployeesDTO request);

    List<EmployeesDTO> getAll();

    Optional<EmployeesDTO> getById(Long id);

    Optional<EmployeesDTO> update(Long id, @Valid EmployeesDTO request);

    List<EmployeesDTO> getByLastName(String name);

    List<EmployeesDTO> getByDepartament(String name);

    List<EmployeesDTO> getByTitle(String name);

    boolean delete(Long id);


}
