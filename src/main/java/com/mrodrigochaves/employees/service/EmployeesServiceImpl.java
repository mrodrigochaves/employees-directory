package com.mrodrigochaves.employees.service;

import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<EmployeesDTO> create(EmployeesDTO request) {

        Employees employees = mapper.map(request, Employees.class);
        repository.saveAndFlush(employees);

        EmployeesDTO response = mapper.map(employees, EmployeesDTO.class);

        return Optional.of(response);
     }

    @Override
    public List<EmployeesDTO> getAll() {
        
        List<Employees> employee = repository.findAll();

        List<EmployeesDTO> responses = new ArrayList<>();

        for(Employees employees : employee){
            EmployeesDTO response = mapper.map(employees, EmployeesDTO.class);
        }
        return responses;    
        
    }

    @Override
    public Optional<EmployeesDTO> getById(Long id) {
        Optional<Employees> employees = repository.findById(id);
        if(employees.isPresent()){
            return Optional.of(mapper.map(employees.get(), EmployeesDTO.class));
        }
        return Optional.empty();
    }

    
    
    
}
