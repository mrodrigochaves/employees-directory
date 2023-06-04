package com.mrodrigochaves.employees.service;

import java.util.Optional;

import com.mrodrigochaves.employees.dto.EmployeesDTO;

public interface EmployeesService {
    
    Optional<EmployeesDTO> create(EmployeesDTO request);

}
