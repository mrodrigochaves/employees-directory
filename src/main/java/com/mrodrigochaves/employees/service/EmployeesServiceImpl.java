package com.mrodrigochaves.employees.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrodrigochaves.employees.dto.EmployeesDTO;
import com.mrodrigochaves.employees.model.Employees;
import com.mrodrigochaves.employees.repository.EmployeesRepository;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesRepository repository;

    @Override
    public Optional<EmployeesDTO> create(EmployeesDTO request) {

        ModelMapper mapper = new ModelMapper();
        Employees employees = mapper.map(request, Employees.class);
        repository.saveAndFlush(employees);

        EmployeesDTO response = mapper.map(employees, EmployeesDTO.class);

        return Optional.of(response);
     }
    
    
}
